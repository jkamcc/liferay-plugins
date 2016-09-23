/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jkamcc.musicbrainz.service.impl;

import com.jkamcc.musicbrainz.model.Artist;
import com.jkamcc.musicbrainz.model.ArtistMeta;
import com.jkamcc.musicbrainz.service.base.ArtistLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;

import java.util.Date;

/**
 * The implementation of the artist local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jkamcc.musicbrainz.service.ArtistLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Juan Carrillo
 * @see com.jkamcc.musicbrainz.service.base.ArtistLocalServiceBaseImpl
 * @see com.jkamcc.musicbrainz.service.ArtistLocalServiceUtil
 */
public class ArtistLocalServiceImpl extends ArtistLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jkamcc.musicbrainz.service.ArtistLocalServiceUtil} to access the artist local service.
	 */

	public void updateAsset(Artist artist) throws SystemException, PortalException {
        Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
	    User user = company.getDefaultUser();
        Date currentDate = new Date();

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(user.getUserId(), user.getGroupId(),
                currentDate, currentDate, Artist.class.getName(), artist.getId(), artist.getGid(), 0, null, null,
                true, null, null, null, ContentTypes.TEXT_HTML, artist.getName(), "description", "summary", null, null,
                0, 0, null, false);

    }

}