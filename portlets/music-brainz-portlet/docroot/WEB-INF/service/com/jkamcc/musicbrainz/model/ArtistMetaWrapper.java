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
 * This class is a wrapper for {@link ArtistMeta}.
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistMeta
 * @generated
 */
public class ArtistMetaWrapper implements ArtistMeta, ModelWrapper<ArtistMeta> {
	public ArtistMetaWrapper(ArtistMeta artistMeta) {
		_artistMeta = artistMeta;
	}

	@Override
	public Class<?> getModelClass() {
		return ArtistMeta.class;
	}

	@Override
	public String getModelClassName() {
		return ArtistMeta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("rating", getRating());
		attributes.put("ratingCount", getRatingCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Integer ratingCount = (Integer)attributes.get("ratingCount");

		if (ratingCount != null) {
			setRatingCount(ratingCount);
		}
	}

	/**
	* Returns the primary key of this artist meta.
	*
	* @return the primary key of this artist meta
	*/
	@Override
	public long getPrimaryKey() {
		return _artistMeta.getPrimaryKey();
	}

	/**
	* Sets the primary key of this artist meta.
	*
	* @param primaryKey the primary key of this artist meta
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_artistMeta.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this artist meta.
	*
	* @return the ID of this artist meta
	*/
	@Override
	public long getId() {
		return _artistMeta.getId();
	}

	/**
	* Sets the ID of this artist meta.
	*
	* @param id the ID of this artist meta
	*/
	@Override
	public void setId(long id) {
		_artistMeta.setId(id);
	}

	/**
	* Returns the rating of this artist meta.
	*
	* @return the rating of this artist meta
	*/
	@Override
	public int getRating() {
		return _artistMeta.getRating();
	}

	/**
	* Sets the rating of this artist meta.
	*
	* @param rating the rating of this artist meta
	*/
	@Override
	public void setRating(int rating) {
		_artistMeta.setRating(rating);
	}

	/**
	* Returns the rating count of this artist meta.
	*
	* @return the rating count of this artist meta
	*/
	@Override
	public int getRatingCount() {
		return _artistMeta.getRatingCount();
	}

	/**
	* Sets the rating count of this artist meta.
	*
	* @param ratingCount the rating count of this artist meta
	*/
	@Override
	public void setRatingCount(int ratingCount) {
		_artistMeta.setRatingCount(ratingCount);
	}

	@Override
	public boolean isNew() {
		return _artistMeta.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_artistMeta.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _artistMeta.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_artistMeta.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _artistMeta.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _artistMeta.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_artistMeta.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _artistMeta.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_artistMeta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_artistMeta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_artistMeta.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArtistMetaWrapper((ArtistMeta)_artistMeta.clone());
	}

	@Override
	public int compareTo(com.jkamcc.musicbrainz.model.ArtistMeta artistMeta) {
		return _artistMeta.compareTo(artistMeta);
	}

	@Override
	public int hashCode() {
		return _artistMeta.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jkamcc.musicbrainz.model.ArtistMeta> toCacheModel() {
		return _artistMeta.toCacheModel();
	}

	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta toEscapedModel() {
		return new ArtistMetaWrapper(_artistMeta.toEscapedModel());
	}

	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta toUnescapedModel() {
		return new ArtistMetaWrapper(_artistMeta.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _artistMeta.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _artistMeta.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_artistMeta.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArtistMetaWrapper)) {
			return false;
		}

		ArtistMetaWrapper artistMetaWrapper = (ArtistMetaWrapper)obj;

		if (Validator.equals(_artistMeta, artistMetaWrapper._artistMeta)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ArtistMeta getWrappedArtistMeta() {
		return _artistMeta;
	}

	@Override
	public ArtistMeta getWrappedModel() {
		return _artistMeta;
	}

	@Override
	public void resetOriginalValues() {
		_artistMeta.resetOriginalValues();
	}

	private ArtistMeta _artistMeta;
}