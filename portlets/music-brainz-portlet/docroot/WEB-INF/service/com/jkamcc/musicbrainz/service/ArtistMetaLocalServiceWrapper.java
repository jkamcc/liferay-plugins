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

package com.jkamcc.musicbrainz.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArtistMetaLocalService}.
 *
 * @author Juan Carrillo
 * @see ArtistMetaLocalService
 * @generated
 */
public class ArtistMetaLocalServiceWrapper implements ArtistMetaLocalService,
	ServiceWrapper<ArtistMetaLocalService> {
	public ArtistMetaLocalServiceWrapper(
		ArtistMetaLocalService artistMetaLocalService) {
		_artistMetaLocalService = artistMetaLocalService;
	}

	/**
	* Adds the artist meta to the database. Also notifies the appropriate model listeners.
	*
	* @param artistMeta the artist meta
	* @return the artist meta that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta addArtistMeta(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.addArtistMeta(artistMeta);
	}

	/**
	* Creates a new artist meta with the primary key. Does not add the artist meta to the database.
	*
	* @param id the primary key for the new artist meta
	* @return the new artist meta
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta createArtistMeta(long id) {
		return _artistMetaLocalService.createArtistMeta(id);
	}

	/**
	* Deletes the artist meta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta that was removed
	* @throws PortalException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta deleteArtistMeta(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.deleteArtistMeta(id);
	}

	/**
	* Deletes the artist meta from the database. Also notifies the appropriate model listeners.
	*
	* @param artistMeta the artist meta
	* @return the artist meta that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta deleteArtistMeta(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.deleteArtistMeta(artistMeta);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _artistMetaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistMetaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jkamcc.musicbrainz.model.impl.ArtistMetaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta fetchArtistMeta(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.fetchArtistMeta(id);
	}

	/**
	* Returns the artist meta with the primary key.
	*
	* @param id the primary key of the artist meta
	* @return the artist meta
	* @throws PortalException if a artist meta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta getArtistMeta(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.getArtistMeta(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.jkamcc.musicbrainz.model.ArtistMeta> getArtistMetas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.getArtistMetas(start, end);
	}

	/**
	* Returns the number of artist metas.
	*
	* @return the number of artist metas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getArtistMetasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.getArtistMetasCount();
	}

	/**
	* Updates the artist meta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param artistMeta the artist meta
	* @return the artist meta that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jkamcc.musicbrainz.model.ArtistMeta updateArtistMeta(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _artistMetaLocalService.updateArtistMeta(artistMeta);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _artistMetaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_artistMetaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _artistMetaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ArtistMetaLocalService getWrappedArtistMetaLocalService() {
		return _artistMetaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedArtistMetaLocalService(
		ArtistMetaLocalService artistMetaLocalService) {
		_artistMetaLocalService = artistMetaLocalService;
	}

	@Override
	public ArtistMetaLocalService getWrappedService() {
		return _artistMetaLocalService;
	}

	@Override
	public void setWrappedService(ArtistMetaLocalService artistMetaLocalService) {
		_artistMetaLocalService = artistMetaLocalService;
	}

	private ArtistMetaLocalService _artistMetaLocalService;
}