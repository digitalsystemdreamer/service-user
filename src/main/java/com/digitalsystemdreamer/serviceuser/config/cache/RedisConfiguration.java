package com.digitalsystemdreamer.serviceuser.config.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {


    @Value("${spring.data.redis.host}")
    private String REDIS_HOSTNAME;
    @Value("${spring.data.redis.port}")
    private int REDIS_PORT;

    @Bean
    protected JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(REDIS_HOSTNAME, REDIS_PORT);
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration,jedisClientConfiguration);
        factory.afterPropertiesSet();
        return factory;
    }
    @Bean
    public RedisTemplate<String,Object> redisTemplate() {
        final RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
       /* final var jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(FacilityDTO.class);

        final var objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL,  JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
*/
/*redisTemplate.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());*/

        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    /*@Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer (){

        return builder -> builder
                .withCacheConfiguration("facilities", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues().prefixCacheNameWith("gym"))
                .withCacheConfiguration("goalsCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(2)).disableCachingNullValues())
                .withCacheConfiguration("questionnaireCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues())
                .withCacheConfiguration("userConditionsCache",RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues())
                .build();
    }*/

    /*@Bean
    public CacheManager getCacheManager() {
        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(jedisConnectionFactory()).withCacheConfiguration("facilities",
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues().prefixCacheNameWith("gym")).build();
        return  new RedisCacheManager(getRedisCacheWriter(), getRedisCacheConfiguration());
    }

    @Bean
    public RedisCacheWriter getRedisCacheWriter() {
        return RedisCacheWriter.lockingRedisCacheWriter(jedisConnectionFactory());
    }

    @Bean
    public RedisCacheConfiguration getRedisCacheConfiguration() {
       return RedisCacheConfiguration
                .defaultCacheConfig().
                prefixCacheNameWith("Gym").
                entryTtl(Duration.ofMinutes(1))
                ;
    }*/

}
