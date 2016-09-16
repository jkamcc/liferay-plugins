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

import com.jkamcc.musicbrainz.model.Artist;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the artist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistPersistenceImpl
 * @see ArtistUtil
 * @generated
 */
public interface ArtistPersistence extends BasePersistence<Artist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArtistUtil} to access the artist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the artist in the entity cache if it is enabled.
	*
	* @param artist the artist
	*/
	public void cacheResult(com.jkamcc.musicbrainz.model.Artist artist);

	/**
	* Caches the artists in the entity cache if it is enabled.
	*
	* @param artists the artists
	*/
	public void cacheResult(
		java.util.List<com.jkamcc.musicbrainz.model.Artist> artists);

	/**
	* Creates a new artist with the primary key. Does not add the artist to the database.
	*
	* @param id the primary key for the new artist
	* @return the new artist
	*/
	public com.jkamcc.musicbrainz.model.Artist create(long id);

	/**
	* Removes the artist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the artist
	* @return the artist that was removed
	* @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.Artist remove(long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jkamcc.musicbrainz.model.Artist updateImpl(
		com.jkamcc.musicbrainz.model.Artist artist)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the artist with the primary key or throws a {@link com.jkamcc.musicbrainz.NoSuchArtistException} if it could not be found.
	*
	* @param id the primary key of the artist
	* @return the artist
	* @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.Artist findByPrimaryKey(long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the artist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the artist
	* @return the artist, or <code>null</code> if a artist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jkamcc.musicbrainz.model.Artist fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the artists.
	*
	* @return the artists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.Artist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of artists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.Artist> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of artists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jkamcc.musicbrainz.model.Artist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the artists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of artists.
	*
	* @return the number of artists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}