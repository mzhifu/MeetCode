package app.meetcode.leetcode.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {

    private static final String HOST = "192.168.1.24";
    private static final int PORT = 6379;
    private static Jedis jedis;

    static {
        jedis = new Jedis(HOST, PORT);
        jedis.auth("Abc_123");
    }



    /**
     * 得到redis连接对象
     */
    public static Jedis getJedis() {
        return jedis;
    }
}
