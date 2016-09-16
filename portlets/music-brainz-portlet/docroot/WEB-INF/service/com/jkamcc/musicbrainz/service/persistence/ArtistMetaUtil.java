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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the artist meta service. This utility wraps {@link ArtistMetaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistMetaPersistence
 * @see ArtistMetaPersistenceImpl
 * @generated
 */
public class ArtistMetaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ArtistMeta artistMeta) {
		getPersistence().clearCache(artistMeta);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArtistMeta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArtistMeta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArtistMeta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ArtistMeta update(ArtistMeta artistMeta)
		throws SystemException {
		return getPersistence().update(artistMeta);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ArtistMeta update(ArtistMeta artistMeta,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(artistMeta, serviceContext);
	}

	/**
	* Caches the artist meta in the entity cache if it is enabled.
	*
	* @param artistMeta the artist meta
	*/
	public static void cacheResult(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta) {
		getPersistence().cacheResult(artistMeta);
	}

	/**
	* Caches the artist metas in the entity cache if it is enabled.
	*
	* @param artistMetas the artist metas
	*/
	public static void cacheResult(
		java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> artistMetas) {
		getPersistence().cacheResult(artistMetas);
	}

	/**
	* Creates a new artist meta with the primary key. Does not add the artist meta to the database.
	*
	* @param id the primary key for the new artist meta
	* @return the new artist meta
	*/
	public static com.jkamcc.musicbrainz.model.ArtistMeta create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the artist meta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta that was removed
	* @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jkamcc.musicbrainz.model.ArtistMeta remove(long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistMetaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.jkamcc.musicbrainz.model.ArtistMeta updateImpl(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(artistMeta);
	}

	/**
	* Returns the artist meta with the primary key or throws a {@link com.jkamcc.musicbrainz.NoSuchArtistMetaException} if it could not be found.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta
	* @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jkamcc.musicbrainz.model.ArtistMeta findByPrimaryKey(
		long id)
		throws com.jkamcc.musicbrainz.NoSuchArtistMetaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the artist meta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta, or <code>null</code> if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jkamcc.musicbrainz.model.ArtistMeta fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the artist metas.
	*
	* @return the artist metas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the artist metas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of artist metas.
	*
	* @return the number of artist metas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArtistMetaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArtistMetaPersistence)PortletBeanLocatorUtil.locate(com.jkamcc.musicbrainz.service.ClpSerializer.getServletContextName(),
					ArtistMetaPersistence.class.getName());

			ReferenceRegistry.registerReference(ArtistMetaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ArtistMetaPersistence persistence) {
	}

	private static ArtistMetaPersistence _persistence;
}