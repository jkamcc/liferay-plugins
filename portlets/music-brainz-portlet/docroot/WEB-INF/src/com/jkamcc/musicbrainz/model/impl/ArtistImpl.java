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

package com.jkamcc.musicbrainz.model.impl;

import com.jkamcc.musicbrainz.model.ArtistMeta;
import com.jkamcc.musicbrainz.service.ArtistMetaLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The extended model implementation for the Artist service. Represents a row in the &quot;artist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jkamcc.musicbrainz.model.Artist} interface.
 * </p>
 *
 * @author Juan Carrillo
 */
public class ArtistImpl extends ArtistBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a artist model instance should use the {@link com.jkamcc.musicbrainz.model.Artist} interface instead.
	 */
	public ArtistImpl() {
	}

	public int getRatings() {
		long id = getId();

		if (Validator.isNull(id)) {
			return 0;
		}

		int ratings = 0;

		try {
			ArtistMeta artistMeta = ArtistMetaLocalServiceUtil.getArtistMeta(getId());
			ratings = artistMeta.getRating();
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return ratings;
	}

	public int getRatingsCount() {
		long id = getId();

		if (Validator.isNull(id)) {
			return 0;
		}

		int ratingsCount = 0;

		try {
			ArtistMeta artistMeta = ArtistMetaLocalServiceUtil.getArtistMeta(getId());
			ratingsCount = artistMeta.getRatingCount();
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return ratingsCount;
	}

	Log _log = LogFactoryUtil.getLog(ArtistImpl.class);
}