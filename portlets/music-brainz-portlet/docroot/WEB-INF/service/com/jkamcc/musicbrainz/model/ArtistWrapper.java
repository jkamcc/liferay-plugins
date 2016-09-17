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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Artist}.
 * </p>
 *
 * @author Juan Carrillo
 * @see Artist
 * @generated
 */
public class ArtistWrapper implements Artist, ModelWrapper<Artist> {
	public ArtistWrapper(Artist artist) {
		_artist = artist;
	}

	@Override
	public Class<?> getModelClass() {
		return Artist.class;
	}

	@Override
	public String getModelClassName() {
		return Artist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("gid", getGid());
		attributes.put("name", getName());
		attributes.put("sortName", getSortName());
		attributes.put("beginDateYear", getBeginDateYear());
		attributes.put("endDateYear", getEndDateYear());
		attributes.put("type", getType());
		attributes.put("area", getArea());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		String gid = (String)attributes.get("gid");

		if (gid != null) {
			setGid(gid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String sortName = (String)attributes.get("sortName");

		if (sortName != null) {
			setSortName(sortName);
		}

		Integer beginDateYear = (Integer)attributes.get("beginDateYear");

		if (beginDateYear != null) {
			setBeginDateYear(beginDateYear);
		}

		Integer endDateYear = (Integer)attributes.get("endDateYear");

		if (endDateYear != null) {
			setEndDateYear(endDateYear);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer area = (Integer)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	/**
	* Returns the primary key of this artist.
	*
	* @return the primary key of this artist
	*/
	@Override
	public long getPrimaryKey() {
		return _artist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this artist.
	*
	* @param primaryKey the primary key of this artist
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_artist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this artist.
	*
	* @return the ID of this artist
	*/
	@Override
	public long getId() {
		return _artist.getId();
	}

	/**
	* Sets the ID of this artist.
	*
	* @param id the ID of this artist
	*/
	@Override
	public void setId(long id) {
		_artist.setId(id);
	}

	/**
	* Returns the resource prim key of this artist.
	*
	* @return the resource prim key of this artist
	*/
	@Override
	public long getResourcePrimKey() {
		return _artist.getResourcePrimKey();
	}

	/**
	* Sets the resource prim key of this artist.
	*
	* @param resourcePrimKey the resource prim key of this artist
	*/
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_artist.setResourcePrimKey(resourcePrimKey);
	}

	@Override
	public boolean isResourceMain() {
		return _artist.isResourceMain();
	}

	/**
	* Returns the gid of this artist.
	*
	* @return the gid of this artist
	*/
	@Override
	public java.lang.String getGid() {
		return _artist.getGid();
	}

	/**
	* Sets the gid of this artist.
	*
	* @param gid the gid of this artist
	*/
	@Override
	public void setGid(java.lang.String gid) {
		_artist.setGid(gid);
	}

	/**
	* Returns the name of this artist.
	*
	* @return the name of this artist
	*/
	@Override
	public java.lang.String getName() {
		return _artist.getName();
	}

	/**
	* Sets the name of this artist.
	*
	* @param name the name of this artist
	*/
	@Override
	public void setName(java.lang.String name) {
		_artist.setName(name);
	}

	/**
	* Returns the sort name of this artist.
	*
	* @return the sort name of this artist
	*/
	@Override
	public java.lang.String getSortName() {
		return _artist.getSortName();
	}

	/**
	* Sets the sort name of this artist.
	*
	* @param sortName the sort name of this artist
	*/
	@Override
	public void setSortName(java.lang.String sortName) {
		_artist.setSortName(sortName);
	}

	/**
	* Returns the begin date year of this artist.
	*
	* @return the begin date year of this artist
	*/
	@Override
	public int getBeginDateYear() {
		return _artist.getBeginDateYear();
	}

	/**
	* Sets the begin date year of this artist.
	*
	* @param beginDateYear the begin date year of this artist
	*/
	@Override
	public void setBeginDateYear(int beginDateYear) {
		_artist.setBeginDateYear(beginDateYear);
	}

	/**
	* Returns the end date year of this artist.
	*
	* @return the end date year of this artist
	*/
	@Override
	public int getEndDateYear() {
		return _artist.getEndDateYear();
	}

	/**
	* Sets the end date year of this artist.
	*
	* @param endDateYear the end date year of this artist
	*/
	@Override
	public void setEndDateYear(int endDateYear) {
		_artist.setEndDateYear(endDateYear);
	}

	/**
	* Returns the type of this artist.
	*
	* @return the type of this artist
	*/
	@Override
	public int getType() {
		return _artist.getType();
	}

	/**
	* Sets the type of this artist.
	*
	* @param type the type of this artist
	*/
	@Override
	public void setType(int type) {
		_artist.setType(type);
	}

	/**
	* Returns the area of this artist.
	*
	* @return the area of this artist
	*/
	@Override
	public int getArea() {
		return _artist.getArea();
	}

	/**
	* Sets the area of this artist.
	*
	* @param area the area of this artist
	*/
	@Override
	public void setArea(int area) {
		_artist.setArea(area);
	}

	/**
	* Returns the gender of this artist.
	*
	* @return the gender of this artist
	*/
	@Override
	public int getGender() {
		return _artist.getGender();
	}

	/**
	* Sets the gender of this artist.
	*
	* @param gender the gender of this artist
	*/
	@Override
	public void setGender(int gender) {
		_artist.setGender(gender);
	}

	@Override
	public boolean isNew() {
		return _artist.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_artist.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _artist.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_artist.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _artist.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _artist.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_artist.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _artist.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_artist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_artist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_artist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArtistWrapper((Artist)_artist.clone());
	}

	@Override
	public int compareTo(com.jkamcc.musicbrainz.model.Artist artist) {
		return _artist.compareTo(artist);
	}

	@Override
	public int hashCode() {
		return _artist.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jkamcc.musicbrainz.model.Artist> toCacheModel() {
		return _artist.toCacheModel();
	}

	@Override
	public com.jkamcc.musicbrainz.model.Artist toEscapedModel() {
		return new ArtistWrapper(_artist.toEscapedModel());
	}

	@Override
	public com.jkamcc.musicbrainz.model.Artist toUnescapedModel() {
		return new ArtistWrapper(_artist.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _artist.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _artist.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_artist.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArtistWrapper)) {
			return false;
		}

		ArtistWrapper artistWrapper = (ArtistWrapper)obj;

		if (Validator.equals(_artist, artistWrapper._artist)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Artist getWrappedArtist() {
		return _artist;
	}

	@Override
	public Artist getWrappedModel() {
		return _artist;
	}

	@Override
	public void resetOriginalValues() {
		_artist.resetOriginalValues();
	}

	private Artist _artist;
}