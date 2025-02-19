package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        // 从池子里获取连接
        jedis=JedisConnectionFactory.getJedis();
        // 选择库
        jedis.select(0);
    }

    @Test
    void testString(){
        //插入数据，方法名就是redis命令名称
        String result = jedis.set("name","张三");
        System.out.println("result="+result);

        // 获取数据
        String name = jedis.get("name");
        System.out.println("name="+name);
    }

    @AfterEach
    void tearDown(){
        if (jedis!=null){
            jedis.close();
        }
    }
}
