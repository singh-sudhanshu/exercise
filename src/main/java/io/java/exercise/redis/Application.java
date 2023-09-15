package io.java.exercise.redis;

import redis.clients.jedis.JedisPooled;

public class Application {

    public static void main(String[] args) {

        try {
            JedisPooled jedisPooled = RedisFactory.getJedisPooled();
            jedisPooled.set("key", "this is value");
            System.out.println(jedisPooled.get("key"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
