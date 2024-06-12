package com.digitalsystemdreamer.serviceuser.repository.cache;

import com.digitalsystemdreamer.serviceuser.dto.FacilityDTO;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepo extends CrudRepository<FacilityDTO, Integer> {
}
