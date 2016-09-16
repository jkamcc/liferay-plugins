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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ArtistMeta in entity cache.
 *
 * @author Juan Carrillo
 * @see ArtistMeta
 * @generated
 */
public class ArtistMetaCacheModel implements CacheModel<ArtistMeta>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", ratingCount=");
		sb.append(ratingCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArtistMeta toEntityModel() {
		ArtistMetaImpl artistMetaImpl = new ArtistMetaImpl();

		artistMetaImpl.setId(id);
		artistMetaImpl.setRating(rating);
		artistMetaImpl.setRatingCount(ratingCount);

		artistMetaImpl.resetOriginalValues();

		return artistMetaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		rating = objectInput.readInt();
		ratingCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeInt(rating);
		objectOutput.writeInt(ratingCount);
	}

	public long id;
	public int rating;
	public int ratingCount;
}