package io.java.exercise.redis;

import redis.clients.jedis.JedisPooled;

public class RedisClient implements RedisFactory {

    @Override
    public JedisPooled getJeddis() {
        return new JedisPooled(" 10.1.0.6", 6379);
    }
}
