package com.digitalsystemdreamer.serviceuser.config.service;


import com.digitalsystemdreamer.serviceuser.config.service.model.ServiceModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {


    @ConfigurationProperties(prefix = "service.refdata.facilities")
    @Bean
    @Qualifier("facilitiesServiceModel")
    public ServiceModel facilitiesServiceModel() {
        return new ServiceModel();
    }

    @ConfigurationProperties(prefix = "service.refdata.membership")
    @Bean
    @Qualifier("membershipServiceModel")
    public ServiceModel membershipServiceModel() {
        return new ServiceModel();
    }

}
