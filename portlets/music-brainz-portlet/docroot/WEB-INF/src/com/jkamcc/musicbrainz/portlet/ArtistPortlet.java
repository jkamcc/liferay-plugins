package com.jkamcc.musicbrainz.portlet;

import com.jkamcc.musicbrainz.model.Artist;
import com.jkamcc.musicbrainz.service.ArtistLocalServiceUtil;
import com.liferay.compat.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author juancarrillo
 */
public class ArtistPortlet extends MVCPortlet {

    @Override
    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {

        try {
            Artist artist = ArtistLocalServiceUtil.getArtist(1l) ;
            System.out.println("artist = " + artist);
            System.out.println("artist = " + artist.getRatings());
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        super.render(request, response);
    }
}
