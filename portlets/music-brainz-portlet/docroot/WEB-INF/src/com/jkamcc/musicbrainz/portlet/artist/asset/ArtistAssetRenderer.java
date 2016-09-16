package com.jkamcc.musicbrainz.portlet.artist.asset;

import com.jkamcc.musicbrainz.model.Artist;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Locale;

/**
 * @author juancarrillo
 */
public class ArtistAssetRenderer extends BaseAssetRenderer {

    public static long getClassPK(Artist artist) {
        return 0;
    }


    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public long getClassPK() {
        return 0;
    }

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public String getSummary(Locale locale) {
        return null;
    }

    @Override
    public String getTitle(Locale locale) {
        return null;
    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUuid() {
        return null;
    }

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
        return null;
    }
}
