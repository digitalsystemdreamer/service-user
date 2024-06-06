/*
package com.digitalsystemdreamer.serviceuser.config.cache;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
public class CacheConfiguration {

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer (){

        return builder -> builder
                .withCacheConfiguration("facilityCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues())
                .withCacheConfiguration("goalsCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(2)).disableCachingNullValues())
                .withCacheConfiguration("questionnaireCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues())
                .withCacheConfiguration("userConditionsCache",RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues())
                .build();
    }

}
*/
