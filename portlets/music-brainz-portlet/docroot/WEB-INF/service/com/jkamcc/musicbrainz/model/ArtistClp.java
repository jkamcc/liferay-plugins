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

import com.jkamcc.musicbrainz.service.ArtistLocalServiceUtil;
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
public class ArtistClp extends BaseModelImpl<Artist> implements Artist {
	public ArtistClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_artistRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setResourcePrimKey", long.class);

				method.invoke(_artistRemoteModel, resourcePrimKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isResourceMain() {
		return _resourceMain;
	}

	public void setResourceMain(boolean resourceMain) {
		_resourceMain = resourceMain;
	}

	@Override
	public String getGid() {
		return _gid;
	}

	@Override
	public void setGid(String gid) {
		_gid = gid;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setGid", String.class);

				method.invoke(_artistRemoteModel, gid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_artistRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSortName() {
		return _sortName;
	}

	@Override
	public void setSortName(String sortName) {
		_sortName = sortName;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setSortName", String.class);

				method.invoke(_artistRemoteModel, sortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBeginDateYear() {
		return _beginDateYear;
	}

	@Override
	public void setBeginDateYear(int beginDateYear) {
		_beginDateYear = beginDateYear;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setBeginDateYear", int.class);

				method.invoke(_artistRemoteModel, beginDateYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndDateYear() {
		return _endDateYear;
	}

	@Override
	public void setEndDateYear(int endDateYear) {
		_endDateYear = endDateYear;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDateYear", int.class);

				method.invoke(_artistRemoteModel, endDateYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_artistRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getArea() {
		return _area;
	}

	@Override
	public void setArea(int area) {
		_area = area;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setArea", int.class);

				method.invoke(_artistRemoteModel, area);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;

		if (_artistRemoteModel != null) {
			try {
				Class<?> clazz = _artistRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", int.class);

				method.invoke(_artistRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getArtistRemoteModel() {
		return _artistRemoteModel;
	}

	public void setArtistRemoteModel(BaseModel<?> artistRemoteModel) {
		_artistRemoteModel = artistRemoteModel;
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

		Class<?> remoteModelClass = _artistRemoteModel.getClass();

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

		Object returnValue = method.invoke(_artistRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArtistLocalServiceUtil.addArtist(this);
		}
		else {
			ArtistLocalServiceUtil.updateArtist(this);
		}
	}

	@Override
	public Artist toEscapedModel() {
		return (Artist)ProxyUtil.newProxyInstance(Artist.class.getClassLoader(),
			new Class[] { Artist.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArtistClp clone = new ArtistClp();

		clone.setId(getId());
		clone.setResourcePrimKey(getResourcePrimKey());
		clone.setGid(getGid());
		clone.setName(getName());
		clone.setSortName(getSortName());
		clone.setBeginDateYear(getBeginDateYear());
		clone.setEndDateYear(getEndDateYear());
		clone.setType(getType());
		clone.setArea(getArea());
		clone.setGender(getGender());

		return clone;
	}

	@Override
	public int compareTo(Artist artist) {
		long primaryKey = artist.getPrimaryKey();

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

		if (!(obj instanceof ArtistClp)) {
			return false;
		}

		ArtistClp artist = (ArtistClp)obj;

		long primaryKey = artist.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", gid=");
		sb.append(getGid());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", sortName=");
		sb.append(getSortName());
		sb.append(", beginDateYear=");
		sb.append(getBeginDateYear());
		sb.append(", endDateYear=");
		sb.append(getEndDateYear());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", area=");
		sb.append(getArea());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.jkamcc.musicbrainz.model.Artist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gid</column-name><column-value><![CDATA[");
		sb.append(getGid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortName</column-name><column-value><![CDATA[");
		sb.append(getSortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginDateYear</column-name><column-value><![CDATA[");
		sb.append(getBeginDateYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDateYear</column-name><column-value><![CDATA[");
		sb.append(getEndDateYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>area</column-name><column-value><![CDATA[");
		sb.append(getArea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _resourcePrimKey;
	private boolean _resourceMain;
	private String _gid;
	private String _name;
	private String _sortName;
	private int _beginDateYear;
	private int _endDateYear;
	private int _type;
	private int _area;
	private int _gender;
	private BaseModel<?> _artistRemoteModel;
	private Class<?> _clpSerializerClass = com.jkamcc.musicbrainz.service.ClpSerializer.class;
}