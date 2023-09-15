package io.java.exercise.redis;

import redis.clients.jedis.JedisPooled;

public interface RedisFactory {

    static JedisPooled getJedisPooled() {
        return new JedisPooled("localhost", 6379);
    }

    JedisPooled getJeddis();
}
