package com.example.springdataredisdemo.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    @Bean
    RedisConnectionFactory redisConnectionFactory(RedisProperties props) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();

        config.setPassword(props.getPassword());

        return new LettuceConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    //Creating Connection with Redis
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(){
//        RedisTemplate<String, Object> empTemplate = new RedisTemplate<>();
//        empTemplate.setConnectionFactory(redisConnectionFactory());
//        return empTemplate;
//    }

//    @Bean
//    JedisConnectionFactory jedisConnectionFactoryMethod() {
//        JedisConnectionFactory myJedisConFactory
//                = new JedisConnectionFactory();
//        myJedisConFactory.setHostName("localhost");
//        myJedisConFactory.setPort(6379);
//        myJedisConFactory.setDatabase(5);
//        myJedisConFactory.setPassword("pass123$");
//        return myJedisConFactory;
//    }
}