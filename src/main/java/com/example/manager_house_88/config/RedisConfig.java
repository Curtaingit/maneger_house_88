package com.example.manager_house_88.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;


@Configuration
@EnableCaching
    public class RedisConfig {
        @Bean
        public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
            CacheManager cacheManager = new RedisCacheManager(redisTemplate);
            return cacheManager;
        }
        @Bean
        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
            redisTemplate.setConnectionFactory(factory);
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            return redisTemplate;
        }
        @Bean
        public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
            StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
            stringRedisTemplate.setConnectionFactory(factory);
            return stringRedisTemplate;
        }
    }