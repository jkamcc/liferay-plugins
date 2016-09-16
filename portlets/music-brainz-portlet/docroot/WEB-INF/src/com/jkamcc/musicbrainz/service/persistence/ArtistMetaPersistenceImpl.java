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

import com.jkamcc.musicbrainz.NoSuchArtistMetaException;
import com.jkamcc.musicbrainz.model.ArtistMeta;
import com.jkamcc.musicbrainz.model.impl.ArtistMetaImpl;
import com.jkamcc.musicbrainz.model.impl.ArtistMetaModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the artist meta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistMetaPersistence
 * @see ArtistMetaUtil
 * @generated
 */
public class ArtistMetaPersistenceImpl extends BasePersistenceImpl<ArtistMeta>
	implements ArtistMetaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArtistMetaUtil} to access the artist meta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArtistMetaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaModelImpl.FINDER_CACHE_ENABLED, ArtistMetaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaModelImpl.FINDER_CACHE_ENABLED, ArtistMetaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ArtistMetaPersistenceImpl() {
		setModelClass(ArtistMeta.class);
	}

	/**
	 * Caches the artist meta in the entity cache if it is enabled.
	 *
	 * @param artistMeta the artist meta
	 */
	@Override
	public void cacheResult(ArtistMeta artistMeta) {
		EntityCacheUtil.putResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaImpl.class, artistMeta.getPrimaryKey(), artistMeta);

		artistMeta.resetOriginalValues();
	}

	/**
	 * Caches the artist metas in the entity cache if it is enabled.
	 *
	 * @param artistMetas the artist metas
	 */
	@Override
	public void cacheResult(List<ArtistMeta> artistMetas) {
		for (ArtistMeta artistMeta : artistMetas) {
			if (EntityCacheUtil.getResult(
						ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
						ArtistMetaImpl.class, artistMeta.getPrimaryKey()) == null) {
				cacheResult(artistMeta);
			}
			else {
				artistMeta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all artist metas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArtistMetaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArtistMetaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the artist meta.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArtistMeta artistMeta) {
		EntityCacheUtil.removeResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaImpl.class, artistMeta.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ArtistMeta> artistMetas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArtistMeta artistMeta : artistMetas) {
			EntityCacheUtil.removeResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
				ArtistMetaImpl.class, artistMeta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new artist meta with the primary key. Does not add the artist meta to the database.
	 *
	 * @param id the primary key for the new artist meta
	 * @return the new artist meta
	 */
	@Override
	public ArtistMeta create(long id) {
		ArtistMeta artistMeta = new ArtistMetaImpl();

		artistMeta.setNew(true);
		artistMeta.setPrimaryKey(id);

		return artistMeta;
	}

	/**
	 * Removes the artist meta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the artist meta
	 * @return the artist meta that was removed
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta remove(long id)
		throws NoSuchArtistMetaException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the artist meta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the artist meta
	 * @return the artist meta that was removed
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta remove(Serializable primaryKey)
		throws NoSuchArtistMetaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ArtistMeta artistMeta = (ArtistMeta)session.get(ArtistMetaImpl.class,
					primaryKey);

			if (artistMeta == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArtistMetaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(artistMeta);
		}
		catch (NoSuchArtistMetaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ArtistMeta removeImpl(ArtistMeta artistMeta)
		throws SystemException {
		artistMeta = toUnwrappedModel(artistMeta);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(artistMeta)) {
				artistMeta = (ArtistMeta)session.get(ArtistMetaImpl.class,
						artistMeta.getPrimaryKeyObj());
			}

			if (artistMeta != null) {
				session.delete(artistMeta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (artistMeta != null) {
			clearCache(artistMeta);
		}

		return artistMeta;
	}

	@Override
	public ArtistMeta updateImpl(
		com.jkamcc.musicbrainz.model.ArtistMeta artistMeta)
		throws SystemException {
		artistMeta = toUnwrappedModel(artistMeta);

		boolean isNew = artistMeta.isNew();

		Session session = null;

		try {
			session = openSession();

			if (artistMeta.isNew()) {
				session.save(artistMeta);

				artistMeta.setNew(false);
			}
			else {
				session.merge(artistMeta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
			ArtistMetaImpl.class, artistMeta.getPrimaryKey(), artistMeta);

		return artistMeta;
	}

	protected ArtistMeta toUnwrappedModel(ArtistMeta artistMeta) {
		if (artistMeta instanceof ArtistMetaImpl) {
			return artistMeta;
		}

		ArtistMetaImpl artistMetaImpl = new ArtistMetaImpl();

		artistMetaImpl.setNew(artistMeta.isNew());
		artistMetaImpl.setPrimaryKey(artistMeta.getPrimaryKey());

		artistMetaImpl.setId(artistMeta.getId());
		artistMetaImpl.setRating(artistMeta.getRating());
		artistMetaImpl.setRatingCount(artistMeta.getRatingCount());

		return artistMetaImpl;
	}

	/**
	 * Returns the artist meta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the artist meta
	 * @return the artist meta
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArtistMetaException, SystemException {
		ArtistMeta artistMeta = fetchByPrimaryKey(primaryKey);

		if (artistMeta == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArtistMetaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return artistMeta;
	}

	/**
	 * Returns the artist meta with the primary key or throws a {@link com.jkamcc.musicbrainz.NoSuchArtistMetaException} if it could not be found.
	 *
	 * @param id the primary key of the artist meta
	 * @return the artist meta
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistMetaException if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta findByPrimaryKey(long id)
		throws NoSuchArtistMetaException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the artist meta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the artist meta
	 * @return the artist meta, or <code>null</code> if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ArtistMeta artistMeta = (ArtistMeta)EntityCacheUtil.getResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
				ArtistMetaImpl.class, primaryKey);

		if (artistMeta == _nullArtistMeta) {
			return null;
		}

		if (artistMeta == null) {
			Session session = null;

			try {
				session = openSession();

				artistMeta = (ArtistMeta)session.get(ArtistMetaImpl.class,
						primaryKey);

				if (artistMeta != null) {
					cacheResult(artistMeta);
				}
				else {
					EntityCacheUtil.putResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
						ArtistMetaImpl.class, primaryKey, _nullArtistMeta);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArtistMetaModelImpl.ENTITY_CACHE_ENABLED,
					ArtistMetaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return artistMeta;
	}

	/**
	 * Returns the artist meta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the artist meta
	 * @return the artist meta, or <code>null</code> if a artist meta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ArtistMeta fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the artist metas.
	 *
	 * @return the artist metas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ArtistMeta> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ArtistMeta> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ArtistMeta> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ArtistMeta> list = (List<ArtistMeta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTISTMETA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTISTMETA;

				if (pagination) {
					sql = sql.concat(ArtistMetaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ArtistMeta>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ArtistMeta>(list);
				}
				else {
					list = (List<ArtistMeta>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the artist metas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ArtistMeta artistMeta : findAll()) {
			remove(artistMeta);
		}
	}

	/**
	 * Returns the number of artist metas.
	 *
	 * @return the number of artist metas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTISTMETA);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the artist meta persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jkamcc.musicbrainz.model.ArtistMeta")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ArtistMeta>> listenersList = new ArrayList<ModelListener<ArtistMeta>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ArtistMeta>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ArtistMetaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARTISTMETA = "SELECT artistMeta FROM ArtistMeta artistMeta";
	private static final String _SQL_COUNT_ARTISTMETA = "SELECT COUNT(artistMeta) FROM ArtistMeta artistMeta";
	private static final String _ORDER_BY_ENTITY_ALIAS = "artistMeta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ArtistMeta exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArtistMetaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"ratingCount"
			});
	private static ArtistMeta _nullArtistMeta = new ArtistMetaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ArtistMeta> toCacheModel() {
				return _nullArtistMetaCacheModel;
			}
		};

	private static CacheModel<ArtistMeta> _nullArtistMetaCacheModel = new CacheModel<ArtistMeta>() {
			@Override
			public ArtistMeta toEntityModel() {
				return _nullArtistMeta;
			}
		};
}