package com.digitalsystemdreamer.serviceuser.service.impl;

import com.digitalsystemdreamer.serviceuser.cache.CacheType;
import com.digitalsystemdreamer.serviceuser.dto.FacilityDTO;
import com.digitalsystemdreamer.serviceuser.dto.MembershipDTO;
import com.digitalsystemdreamer.serviceuser.service.IRefDataService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Data
public class RefDataServiceImpl implements IRefDataService {

    private RedisTemplate redisTemplate;

    @Override
    public <T> List<T> saveDataInCache(@NonNull CacheType type, @NonNull List<T> data) {

        if(type == CacheType.FACILITIES) {
            log.info("Caching {} Facility  to Redis Cache.. ", data.size());
            redisTemplate.opsForValue().set(CacheType.FACILITIES.getValue(), data.toString(), Duration.ofMinutes(1));
        } else if(type == CacheType.MEMBERSHIP) {
            log.info("Caching {} Membership  to Redis Cache.. ", data.size());
            redisTemplate.opsForValue().set(CacheType.MEMBERSHIP.getValue(), data.toString(), Duration.ofMinutes(1));
        }
        return List.of();
    }

    @Override
    public <T> List<T> getFromCache(@NonNull CacheType type) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        T[] list = switch (type) {
            case FACILITIES -> (T[]) mapper.readValue((JsonParser) redisTemplate.opsForValue().get(CacheType.FACILITIES.getValue()), FacilityDTO[].class);
            case MEMBERSHIP -> (T[]) mapper.readValue((JsonParser) redisTemplate.opsForValue().get(CacheType.MEMBERSHIP.getValue()), MembershipDTO[].class);
            case GOALS -> (T[]) mapper.readValue((JsonParser) redisTemplate.opsForValue().get(CacheType.MEMBERSHIP.getValue()), MembershipDTO[].class);
            case QUESTIONNAIRE -> (T[]) mapper.readValue((JsonParser) redisTemplate.opsForValue().get(CacheType.MEMBERSHIP.getValue()), MembershipDTO[].class);

        };

        //ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(list);
    }
}
