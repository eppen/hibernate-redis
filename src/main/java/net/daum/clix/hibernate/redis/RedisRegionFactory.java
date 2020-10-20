package net.daum.clix.hibernate.redis;

import java.util.Properties;

import org.hibernate.cache.CacheException;
import org.hibernate.cfg.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * @author jtlee
 * @author 84june
 */
public class RedisRegionFactory extends AbstractRedisRegionFactory {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public RedisRegionFactory(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void start(Settings settings, Properties properties) throws CacheException {
        this.settings = settings;
        this.properties = properties;
        logger.info("Initializing RedisClient(Jedis)...");
        this.pool = new JedisPool(new JedisPoolConfig(), properties.getProperty("redis.host", "localhost"),
                Integer.valueOf(properties.getProperty("redis.port", String.valueOf(Protocol.DEFAULT_PORT))),
                Integer.valueOf(properties.getProperty("redis.timeout",String.valueOf(Protocol.DEFAULT_TIMEOUT))),
                properties.getProperty("redis.password",null));
    }

    @Override
    public void stop() {
        this.pool.destroy();
    }

  /*  @Override
    public NaturalIdRegion buildNaturalIdRegion(String regionName, Properties properties, CacheDataDescription metadata) throws CacheException {
        throw new NotImplementedException(); //TODO still not implemented
    }*/

}
