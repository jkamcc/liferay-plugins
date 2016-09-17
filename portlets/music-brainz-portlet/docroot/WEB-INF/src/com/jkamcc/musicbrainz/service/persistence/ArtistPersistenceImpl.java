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

import com.jkamcc.musicbrainz.NoSuchArtistException;
import com.jkamcc.musicbrainz.model.Artist;
import com.jkamcc.musicbrainz.model.impl.ArtistImpl;
import com.jkamcc.musicbrainz.model.impl.ArtistModelImpl;

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
 * The persistence implementation for the artist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Juan Carrillo
 * @see ArtistPersistence
 * @see ArtistUtil
 * @generated
 */
public class ArtistPersistenceImpl extends BasePersistenceImpl<Artist>
	implements ArtistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArtistUtil} to access the artist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArtistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistModelImpl.FINDER_CACHE_ENABLED, ArtistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistModelImpl.FINDER_CACHE_ENABLED, ArtistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ArtistPersistenceImpl() {
		setModelClass(Artist.class);
	}

	/**
	 * Caches the artist in the entity cache if it is enabled.
	 *
	 * @param artist the artist
	 */
	@Override
	public void cacheResult(Artist artist) {
		EntityCacheUtil.putResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistImpl.class, artist.getPrimaryKey(), artist);

		artist.resetOriginalValues();
	}

	/**
	 * Caches the artists in the entity cache if it is enabled.
	 *
	 * @param artists the artists
	 */
	@Override
	public void cacheResult(List<Artist> artists) {
		for (Artist artist : artists) {
			if (EntityCacheUtil.getResult(
						ArtistModelImpl.ENTITY_CACHE_ENABLED, ArtistImpl.class,
						artist.getPrimaryKey()) == null) {
				cacheResult(artist);
			}
			else {
				artist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all artists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArtistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArtistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the artist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Artist artist) {
		EntityCacheUtil.removeResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistImpl.class, artist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Artist> artists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Artist artist : artists) {
			EntityCacheUtil.removeResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
				ArtistImpl.class, artist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new artist with the primary key. Does not add the artist to the database.
	 *
	 * @param id the primary key for the new artist
	 * @return the new artist
	 */
	@Override
	public Artist create(long id) {
		Artist artist = new ArtistImpl();

		artist.setNew(true);
		artist.setPrimaryKey(id);

		return artist;
	}

	/**
	 * Removes the artist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the artist
	 * @return the artist that was removed
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist remove(long id) throws NoSuchArtistException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the artist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the artist
	 * @return the artist that was removed
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist remove(Serializable primaryKey)
		throws NoSuchArtistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Artist artist = (Artist)session.get(ArtistImpl.class, primaryKey);

			if (artist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArtistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(artist);
		}
		catch (NoSuchArtistException nsee) {
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
	protected Artist removeImpl(Artist artist) throws SystemException {
		artist = toUnwrappedModel(artist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(artist)) {
				artist = (Artist)session.get(ArtistImpl.class,
						artist.getPrimaryKeyObj());
			}

			if (artist != null) {
				session.delete(artist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (artist != null) {
			clearCache(artist);
		}

		return artist;
	}

	@Override
	public Artist updateImpl(com.jkamcc.musicbrainz.model.Artist artist)
		throws SystemException {
		artist = toUnwrappedModel(artist);

		boolean isNew = artist.isNew();

		Session session = null;

		try {
			session = openSession();

			if (artist.isNew()) {
				session.save(artist);

				artist.setNew(false);
			}
			else {
				session.merge(artist);
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

		EntityCacheUtil.putResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
			ArtistImpl.class, artist.getPrimaryKey(), artist);

		return artist;
	}

	protected Artist toUnwrappedModel(Artist artist) {
		if (artist instanceof ArtistImpl) {
			return artist;
		}

		ArtistImpl artistImpl = new ArtistImpl();

		artistImpl.setNew(artist.isNew());
		artistImpl.setPrimaryKey(artist.getPrimaryKey());

		artistImpl.setId(artist.getId());
		artistImpl.setResourcePrimKey(artist.getResourcePrimKey());
		artistImpl.setGid(artist.getGid());
		artistImpl.setName(artist.getName());
		artistImpl.setSortName(artist.getSortName());
		artistImpl.setBeginDateYear(artist.getBeginDateYear());
		artistImpl.setEndDateYear(artist.getEndDateYear());
		artistImpl.setType(artist.getType());
		artistImpl.setArea(artist.getArea());
		artistImpl.setGender(artist.getGender());

		return artistImpl;
	}

	/**
	 * Returns the artist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the artist
	 * @return the artist
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArtistException, SystemException {
		Artist artist = fetchByPrimaryKey(primaryKey);

		if (artist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArtistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return artist;
	}

	/**
	 * Returns the artist with the primary key or throws a {@link com.jkamcc.musicbrainz.NoSuchArtistException} if it could not be found.
	 *
	 * @param id the primary key of the artist
	 * @return the artist
	 * @throws com.jkamcc.musicbrainz.NoSuchArtistException if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist findByPrimaryKey(long id)
		throws NoSuchArtistException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the artist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the artist
	 * @return the artist, or <code>null</code> if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Artist artist = (Artist)EntityCacheUtil.getResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
				ArtistImpl.class, primaryKey);

		if (artist == _nullArtist) {
			return null;
		}

		if (artist == null) {
			Session session = null;

			try {
				session = openSession();

				artist = (Artist)session.get(ArtistImpl.class, primaryKey);

				if (artist != null) {
					cacheResult(artist);
				}
				else {
					EntityCacheUtil.putResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
						ArtistImpl.class, primaryKey, _nullArtist);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArtistModelImpl.ENTITY_CACHE_ENABLED,
					ArtistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return artist;
	}

	/**
	 * Returns the artist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the artist
	 * @return the artist, or <code>null</code> if a artist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Artist fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the artists.
	 *
	 * @return the artists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Artist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Artist> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Artist> findAll(int start, int end,
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

		List<Artist> list = (List<Artist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTIST;

				if (pagination) {
					sql = sql.concat(ArtistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Artist>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Artist>(list);
				}
				else {
					list = (List<Artist>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the artists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Artist artist : findAll()) {
			remove(artist);
		}
	}

	/**
	 * Returns the number of artists.
	 *
	 * @return the number of artists
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

				Query q = session.createQuery(_SQL_COUNT_ARTIST);

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
	 * Initializes the artist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jkamcc.musicbrainz.model.Artist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Artist>> listenersList = new ArrayList<ModelListener<Artist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Artist>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ArtistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARTIST = "SELECT artist FROM Artist artist";
	private static final String _SQL_COUNT_ARTIST = "SELECT COUNT(artist) FROM Artist artist";
	private static final String _ORDER_BY_ENTITY_ALIAS = "artist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Artist exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArtistPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"resourcePrimKey", "sortName", "beginDateYear", "endDateYear"
			});
	private static Artist _nullArtist = new ArtistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Artist> toCacheModel() {
				return _nullArtistCacheModel;
			}
		};

	private static CacheModel<Artist> _nullArtistCacheModel = new CacheModel<Artist>() {
			@Override
			public Artist toEntityModel() {
				return _nullArtist;
			}
		};
}