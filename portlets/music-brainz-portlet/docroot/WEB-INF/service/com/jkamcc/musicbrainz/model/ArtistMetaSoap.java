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

package com.jkamcc.musicbrainz.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Juan Carrillo
 * @generated
 */
public class ArtistMetaSoap implements Serializable {
	public static ArtistMetaSoap toSoapModel(ArtistMeta model) {
		ArtistMetaSoap soapModel = new ArtistMetaSoap();

		soapModel.setId(model.getId());
		soapModel.setRating(model.getRating());
		soapModel.setRatingCount(model.getRatingCount());

		return soapModel;
	}

	public static ArtistMetaSoap[] toSoapModels(ArtistMeta[] models) {
		ArtistMetaSoap[] soapModels = new ArtistMetaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArtistMetaSoap[][] toSoapModels(ArtistMeta[][] models) {
		ArtistMetaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArtistMetaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArtistMetaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArtistMetaSoap[] toSoapModels(List<ArtistMeta> models) {
		List<ArtistMetaSoap> soapModels = new ArrayList<ArtistMetaSoap>(models.size());

		for (ArtistMeta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArtistMetaSoap[soapModels.size()]);
	}

	public ArtistMetaSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public int getRating() {
		return _rating;
	}

	public void setRating(int rating) {
		_rating = rating;
	}

	public int getRatingCount() {
		return _ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		_ratingCount = ratingCount;
	}

	private long _id;
	private int _rating;
	private int _ratingCount;
}