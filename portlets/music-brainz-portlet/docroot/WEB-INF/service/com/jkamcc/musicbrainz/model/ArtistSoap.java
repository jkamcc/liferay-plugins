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
public class ArtistSoap implements Serializable {
	public static ArtistSoap toSoapModel(Artist model) {
		ArtistSoap soapModel = new ArtistSoap();

		soapModel.setId(model.getId());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());
		soapModel.setGid(model.getGid());
		soapModel.setName(model.getName());
		soapModel.setSortName(model.getSortName());
		soapModel.setBeginDateYear(model.getBeginDateYear());
		soapModel.setEndDateYear(model.getEndDateYear());
		soapModel.setType(model.getType());
		soapModel.setArea(model.getArea());
		soapModel.setGender(model.getGender());

		return soapModel;
	}

	public static ArtistSoap[] toSoapModels(Artist[] models) {
		ArtistSoap[] soapModels = new ArtistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArtistSoap[][] toSoapModels(Artist[][] models) {
		ArtistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArtistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArtistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArtistSoap[] toSoapModels(List<Artist> models) {
		List<ArtistSoap> soapModels = new ArrayList<ArtistSoap>(models.size());

		for (Artist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArtistSoap[soapModels.size()]);
	}

	public ArtistSoap() {
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

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public String getGid() {
		return _gid;
	}

	public void setGid(String gid) {
		_gid = gid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSortName() {
		return _sortName;
	}

	public void setSortName(String sortName) {
		_sortName = sortName;
	}

	public int getBeginDateYear() {
		return _beginDateYear;
	}

	public void setBeginDateYear(int beginDateYear) {
		_beginDateYear = beginDateYear;
	}

	public int getEndDateYear() {
		return _endDateYear;
	}

	public void setEndDateYear(int endDateYear) {
		_endDateYear = endDateYear;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getArea() {
		return _area;
	}

	public void setArea(int area) {
		_area = area;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	private long _id;
	private long _resourcePrimKey;
	private String _gid;
	private String _name;
	private String _sortName;
	private int _beginDateYear;
	private int _endDateYear;
	private int _type;
	private int _area;
	private int _gender;
}