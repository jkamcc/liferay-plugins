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

import com.jkamcc.musicbrainz.model.Artist;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Artist in entity cache.
 *
 * @author Juan Carrillo
 * @see Artist
 * @generated
 */
public class ArtistCacheModel implements CacheModel<Artist>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", gid=");
		sb.append(gid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", sortName=");
		sb.append(sortName);
		sb.append(", beginDateYear=");
		sb.append(beginDateYear);
		sb.append(", endDateYear=");
		sb.append(endDateYear);
		sb.append(", type=");
		sb.append(type);
		sb.append(", area=");
		sb.append(area);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Artist toEntityModel() {
		ArtistImpl artistImpl = new ArtistImpl();

		artistImpl.setId(id);
		artistImpl.setResourcePrimKey(resourcePrimKey);

		if (gid == null) {
			artistImpl.setGid(StringPool.BLANK);
		}
		else {
			artistImpl.setGid(gid);
		}

		if (name == null) {
			artistImpl.setName(StringPool.BLANK);
		}
		else {
			artistImpl.setName(name);
		}

		if (sortName == null) {
			artistImpl.setSortName(StringPool.BLANK);
		}
		else {
			artistImpl.setSortName(sortName);
		}

		artistImpl.setBeginDateYear(beginDateYear);
		artistImpl.setEndDateYear(endDateYear);
		artistImpl.setType(type);
		artistImpl.setArea(area);
		artistImpl.setGender(gender);

		artistImpl.resetOriginalValues();

		return artistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		resourcePrimKey = objectInput.readLong();
		gid = objectInput.readUTF();
		name = objectInput.readUTF();
		sortName = objectInput.readUTF();
		beginDateYear = objectInput.readInt();
		endDateYear = objectInput.readInt();
		type = objectInput.readInt();
		area = objectInput.readInt();
		gender = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(resourcePrimKey);

		if (gid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gid);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (sortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sortName);
		}

		objectOutput.writeInt(beginDateYear);
		objectOutput.writeInt(endDateYear);
		objectOutput.writeInt(type);
		objectOutput.writeInt(area);
		objectOutput.writeInt(gender);
	}

	public long id;
	public long resourcePrimKey;
	public String gid;
	public String name;
	public String sortName;
	public int beginDateYear;
	public int endDateYear;
	public int type;
	public int area;
	public int gender;
}