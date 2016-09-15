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
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this artist.
	*
	* @return the primary key of this artist
	*/
	@Override
	public java.lang.Integer getPrimaryKey() {
		return _artist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this artist.
	*
	* @param primaryKey the primary key of this artist
	*/
	@Override
	public void setPrimaryKey(java.lang.Integer primaryKey) {
		_artist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this artist.
	*
	* @return the ID of this artist
	*/
	@Override
	public java.lang.Integer getId() {
		return _artist.getId();
	}

	/**
	* Sets the ID of this artist.
	*
	* @param id the ID of this artist
	*/
	@Override
	public void setId(java.lang.Integer id) {
		_artist.setId(id);
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