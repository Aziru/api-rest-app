package com.aziru.restworld.config;

import java.util.HashMap;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Bean
    public CacheManager cacheManager(final RedissonClient redissonClient) {
	final Map<String, CacheConfig> config = new HashMap<>();
	config.put("users", new CacheConfig());
	return new RedissonSpringCacheManager(redissonClient);
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
	final var config = new Config();
	config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);
	return Redisson.create(config);
    }
}
