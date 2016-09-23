package com.jkamcc.musicbrainz.portlet.artist.search;

import com.jkamcc.musicbrainz.model.Artist;
import com.jkamcc.musicbrainz.model.ArtistMeta;
import com.jkamcc.musicbrainz.service.ArtistLocalServiceUtil;
import com.jkamcc.musicbrainz.service.ArtistMetaLocalServiceUtil;
import com.jkamcc.musicbrainz.service.persistence.ArtistActionableDynamicQuery;
import com.jkamcc.musicbrainz.util.PortletKeys;
import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.*;

import javax.portlet.PortletURL;
import java.util.Locale;

/**
 * @author juancarrillo
 */
public class ArtistIndexer extends BaseIndexer {

    public static final String[] CLASS_NAMES = {Artist.class.getName()};

    public static final String PORTLET_ID = PortletKeys.MUSIC_BRAINZ;

    @Override
    public String[] getClassNames() {
        return CLASS_NAMES;
    }

    @Override
    public String getPortletId() {
        return PORTLET_ID;
    }

    @Override
    protected void doDelete(Object obj) throws Exception {
        //not implemented method
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {
        Artist artist = (Artist) obj;

        Document document = getBaseModelDocument(PORTLET_ID, artist);

        long classPK = artist.getId();

        document.addUID(PORTLET_ID, classPK);

        document.addText(Field.NAME, artist.getName());

        ArtistMeta artistMeta = ArtistMetaLocalServiceUtil.getArtistMeta(artist.getId());

        document.addNumber(Field.RATINGS, artistMeta.getRating());
        document.addNumber("ratingsCount", artistMeta.getRatingCount());

        return document;
    }

    @Override
    protected Summary doGetSummary(
            Document document, Locale locale, String snippet, PortletURL portletURL) throws Exception {

        String entryId = document.get(Field.ENTRY_CLASS_PK);
        portletURL.setParameter("struts_action", "/blogs/view_entry");
        portletURL.setParameter("entryId", entryId);

        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);
        summary.setPortletURL(portletURL);

        return summary;
    }

    @Override
    protected void doReindex(Object obj) throws Exception {

        SearchEngineUtil.updateDocument(getSearchEngineId(), PortalUtil.getDefaultCompanyId(), getDocument(obj));
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        Artist artist = ArtistLocalServiceUtil.getArtist(classPK);

        if (artist != null) {
            doReindex(artist);
        }
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        reindexArtists();
    }

    protected void reindexArtists() throws SystemException, PortalException {

        ActionableDynamicQuery actionableDynamicQuery = new ArtistActionableDynamicQuery() {

            @Override
            protected void performAction(Object object) throws PortalException, SystemException {
                Artist artist = (Artist) object;
                Document document = getDocument(artist);

                addDocument(document);
            }
        };

        //actionableDynamicQuery.setCompanyId(0l); //no company id needed
        actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

        actionableDynamicQuery.performActions();
    }

    @Override
    protected String getPortletId(SearchContext searchContext) {
        return PORTLET_ID;
    }
}
