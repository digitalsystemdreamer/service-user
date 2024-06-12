package com.digitalsystemdreamer.serviceuser.service.impl;

import com.digitalsystemdreamer.serviceuser.cache.CacheType;
import com.digitalsystemdreamer.serviceuser.dto.BaseDTO;
import com.digitalsystemdreamer.serviceuser.dto.FacilityDTO;
import com.digitalsystemdreamer.serviceuser.dto.MembershipDTO;
import com.digitalsystemdreamer.serviceuser.repository.cache.FacilityRepo;
import com.digitalsystemdreamer.serviceuser.service.IRefDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Data
public class RefDataServiceImpl implements IRefDataService {

    private FacilityRepo facilityRepo;

    private RedisTemplate redisTemplate;

    @Override
    public <T> void saveDataInCache(@NonNull CacheType type, @NonNull List<T> data) {

        if(type == CacheType.FACILITIES) {
            log.info("Caching {} Facility  to Redis Cache.. ", data.size());
            redisTemplate.opsForValue().set(CacheType.FACILITIES.getValue(), new Gson().toJson(data), Duration.ofMinutes(20));

        } else if(type == CacheType.MEMBERSHIP) {
            log.info("Caching {} Membership  to Redis Cache.. ", data.size());
            redisTemplate.opsForValue().set(CacheType.MEMBERSHIP.getValue(), new Gson().toJson(data), Duration.ofMinutes(20));
        }

    }

    @Override
    public BaseDTO getFromCache(@NonNull CacheType type, Integer id) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String cachedValue = (String) redisTemplate.opsForValue().get(CacheType.FACILITIES.getValue());

         BaseDTO dto = switch (type) {
            case FACILITIES -> {
               yield mapper.readValue(cachedValue, new TypeReference<List<FacilityDTO>>(){})
                         .stream().filter(facilityDTO -> facilityDTO.getFacilityId().equals(id)).findFirst().orElseThrow();

            }
            case MEMBERSHIP -> {
                yield mapper.readValue(cachedValue, new TypeReference<List<MembershipDTO>>(){})
                        .stream().filter(membershipDTO -> membershipDTO.getMembershipId().equals(id)).findFirst().orElseThrow();
            }
             default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        return dto;
    }

}
