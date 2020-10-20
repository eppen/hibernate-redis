package net.daum.clix.hibernate.redis.region;

import java.util.Properties;

import org.hibernate.cache.CacheDataDescription;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.CollectionRegion;
import org.hibernate.cache.access.AccessType;
import org.hibernate.cache.access.CollectionRegionAccessStrategy;
import org.hibernate.cfg.Settings;

import net.daum.clix.hibernate.redis.RedisCache;
import net.daum.clix.hibernate.redis.strategy.RedisAccessStrategyFactory;

/**
 * @author jtlee
 * @author 84june
 */
public class RedisCollectionRegion extends RedisTransactionalRegion implements CollectionRegion {

	public RedisCollectionRegion(RedisAccessStrategyFactory accessStrategyFactory, RedisCache cache, Properties properties, CacheDataDescription metadata, Settings settings) {
		super(accessStrategyFactory, cache, properties, metadata, settings);
	}

	@Override
	public CollectionRegionAccessStrategy buildAccessStrategy(AccessType accessType) throws CacheException {
		return accessStrategyFactory.createCollectionRegionAccessStrategy(this, accessType);
	}
}

