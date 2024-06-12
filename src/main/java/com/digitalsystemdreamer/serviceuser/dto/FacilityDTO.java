package com.digitalsystemdreamer.serviceuser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash(value = "facilities")
@NoArgsConstructor
public class FacilityDTO extends BaseDTO implements Serializable {

    @Id
    private Integer facilityId;
    private String name;
    private String description;

}
