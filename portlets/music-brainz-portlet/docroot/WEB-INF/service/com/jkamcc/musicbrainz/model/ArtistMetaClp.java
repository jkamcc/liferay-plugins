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

import com.jkamcc.musicbrainz.service.ArtistMetaLocalServiceUtil;
import com.jkamcc.musicbrainz.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Juan Carrillo
 */
public class ArtistMetaClp extends BaseModelImpl<ArtistMeta>
	implements ArtistMeta {
	public ArtistMetaClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_artistMetaRemoteModel != null) {
			try {
				Class<?> clazz = _artistMetaRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_artistMetaRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRating() {
		return _rating;
	}

	@Override
	public void setRating(int rating) {
		_rating = rating;

		if (_artistMetaRemoteModel != null) {
			try {
				Class<?> clazz = _artistMetaRemoteModel.getClass();

				Method method = clazz.getMethod("setRating", int.class);

				method.invoke(_artistMetaRemoteModel, rating);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRatingCount() {
		return _ratingCount;
	}

	@Override
	public void setRatingCount(int ratingCount) {
		_ratingCount = ratingCount;

		if (_artistMetaRemoteModel != null) {
			try {
				Class<?> clazz = _artistMetaRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingCount", int.class);

				method.invoke(_artistMetaRemoteModel, ratingCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getArtistMetaRemoteModel() {
		return _artistMetaRemoteModel;
	}

	public void setArtistMetaRemoteModel(BaseModel<?> artistMetaRemoteModel) {
		_artistMetaRemoteModel = artistMetaRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _artistMetaRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_artistMetaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArtistMetaLocalServiceUtil.addArtistMeta(this);
		}
		else {
			ArtistMetaLocalServiceUtil.updateArtistMeta(this);
		}
	}

	@Override
	public ArtistMeta toEscapedModel() {
		return (ArtistMeta)ProxyUtil.newProxyInstance(ArtistMeta.class.getClassLoader(),
			new Class[] { ArtistMeta.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArtistMetaClp clone = new ArtistMetaClp();

		clone.setId(getId());
		clone.setRating(getRating());
		clone.setRatingCount(getRatingCount());

		return clone;
	}

	@Override
	public int compareTo(ArtistMeta artistMeta) {
		long primaryKey = artistMeta.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArtistMetaClp)) {
			return false;
		}

		ArtistMetaClp artistMeta = (ArtistMetaClp)obj;

		long primaryKey = artistMeta.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", ratingCount=");
		sb.append(getRatingCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.jkamcc.musicbrainz.model.ArtistMeta");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingCount</column-name><column-value><![CDATA[");
		sb.append(getRatingCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private int _rating;
	private int _ratingCount;
	private BaseModel<?> _artistMetaRemoteModel;
	private Class<?> _clpSerializerClass = com.jkamcc.musicbrainz.service.ClpSerializer.class;
}