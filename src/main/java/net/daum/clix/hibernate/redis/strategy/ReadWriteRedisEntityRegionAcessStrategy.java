package net.daum.clix.hibernate.redis.strategy;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.EntityRegion;
import org.hibernate.cache.access.EntityRegionAccessStrategy;
import org.hibernate.cache.access.SoftLock;
import org.hibernate.cfg.Settings;

import net.daum.clix.hibernate.redis.region.RedisEntityRegion;

/**
 * User: jtlee
 * Date: 3/5/13
 * Time: 2:52 PM
 */
public class ReadWriteRedisEntityRegionAcessStrategy extends AbstractReadWriteRedisAccessStrategy<RedisEntityRegion> implements EntityRegionAccessStrategy {

    /**
     * Create an access strategy wrapping the given region.
     */
    ReadWriteRedisEntityRegionAcessStrategy(RedisEntityRegion region, Settings settings) {
        super(region, settings);
    }



    @Override
    public SoftLock lockItem(Object key, Object version) throws CacheException {
        //Do not support client side lock
        return null;
    }

    @Override
    public void unlockItem(Object key, SoftLock lock) throws CacheException {
        //Do not support client side lock
    }

    @Override
    public EntityRegion getRegion() {
        return region;
    }


}
