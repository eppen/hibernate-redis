package net.daum.clix.hibernate.redis.strategy;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.CollectionRegion;
import org.hibernate.cache.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.access.SoftLock;
import org.hibernate.cfg.Settings;

import net.daum.clix.hibernate.redis.region.RedisCollectionRegion;

/**
 * User: jtlee
 * Date: 3/5/13
 * Time: 1:50 PM
 */
public class ReadWriteRedisCollectionRegionAcessStrategy extends AbstractReadWriteRedisAccessStrategy<RedisCollectionRegion> implements CollectionRegionAccessStrategy {

    /**
     * Create an access strategy wrapping the given region.
     */
    ReadWriteRedisCollectionRegionAcessStrategy(RedisCollectionRegion region, Settings settings) {
        super(region, settings);
    }

    @Override
    public CollectionRegion getRegion() {
        return region;
    }

    @Override
    public SoftLock lockItem(Object key, Object version) throws CacheException {
        //Do not support client-side locking
        return null;
    }

    @Override
    public void unlockItem(Object key, SoftLock lock) throws CacheException {
        //Do not support client-side locking
    }
}
