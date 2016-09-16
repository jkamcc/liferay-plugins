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

package com.jkamcc.musicbrainz.service.persistence;

import com.jkamcc.musicbrainz.model.ArtistMeta;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the artist meta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistMetaPersistenceImpl
 * @see ArtistMetaUtil
 * @generated
 */
public interface ArtistMetaPersistence extends BasePersistence<ArtistMeta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArtistMetaUtil} to access the artist meta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the artist meta in the entity cache if it is enabled.
	*
	* @param artistMeta the artist meta
	*/
	public void cacheResult(com.jkamcc.musicbrainz.model.ArtistMeta artistMeta);

	/**
	* Caches the artist metas in the entity cache if it is enabled.
	*
	* @param artistMetas the artist metas
	*/
	public void cacheResult(
		java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> artistMetas);

	/**
	* Creates a new artist meta with the primary key. Does not add the artist meta to the database.
	*
	* @param id the primary key for the new artist meta
	* @return the new artist meta
	*/
	public com.jkamcc.musicbrainz.model.ArtistMeta create(long id);

	/**
	* Removes the artist meta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta that was removed
	* @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.ArtistMeta remove(long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistMetaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jkamcc.musicbrainz.model.ArtistMeta updateImpl(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the artist meta with the primary key or throws a {@link com.jkamcc.musicbrainz.NoSuchArtistMetaException} if it could not be found.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta
	* @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.ArtistMeta findByPrimaryKey(long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistMetaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the artist meta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta, or <code>null</code> if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.ArtistMeta fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the artist metas.
	*
	* @return the artist metas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the artist metas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistMetaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artist metas
	* @param end the upper bound of the range of artist metas (not inclusive)
	* @return the range of artist metas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the artist metas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistMetaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artist metas
	* @param end the upper bound of the range of artist metas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of artist metas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the artist metas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of artist metas.
	*
	* @return the number of artist metas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}