package com.digitalsystemdreamer.serviceuser.cache;


import com.digitalsystemdreamer.serviceuser.config.service.model.ServiceModel;
import com.digitalsystemdreamer.serviceuser.dto.FacilityDTO;
import com.digitalsystemdreamer.serviceuser.dto.MembershipDTO;
import com.digitalsystemdreamer.serviceuser.service.IRefDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class CacheReader {

    @Qualifier("facilitiesServiceModel")
    @Autowired
    private ServiceModel facilitiesServiceModel;

    @Qualifier("membershipServiceModel")
    @Autowired
    private ServiceModel membershipServiceModel;

    @Autowired
    private IRefDataService refDataService;

    @EventListener(ApplicationReadyEvent.class)
    public void readCache() {

        readFaciltiesRefData();
        //readMembershipRefData();

    }

    private void readMembershipRefData() {

        log.debug("Started loading Membership ref data..");
        RestTemplate membershipRestTemplate = new RestTemplate();

        List<MembershipDTO> mebershipList =  membershipRestTemplate.exchange(
                membershipServiceModel.getUrl(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MembershipDTO>>() {
                }).getBody();

        refDataService.saveDataInCache(CacheType.MEMBERSHIP, mebershipList);
        log.info("Loaded Membership ref data into Redis Cache..");

    }

    public void readFaciltiesRefData() {

        log.debug("Started loading Facilities ref data..");
        RestTemplate facilitiesRestTemplate = new RestTemplate();

        List<FacilityDTO> facilitiesList = facilitiesRestTemplate.exchange(
                facilitiesServiceModel.getUrl(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FacilityDTO>>() {
        }).getBody();

        refDataService.saveDataInCache(CacheType.FACILITIES, facilitiesList);

        log.info("Loaded Facilities ref data into Redis Cache..");
    }

}
