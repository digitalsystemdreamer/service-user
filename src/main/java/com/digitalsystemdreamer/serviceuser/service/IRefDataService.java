package com.digitalsystemdreamer.serviceuser.service;

import com.digitalsystemdreamer.serviceuser.cache.CacheType;
import com.digitalsystemdreamer.serviceuser.dto.BaseDTO;

import java.io.IOException;
import java.util.List;

public interface IRefDataService {

    <T> void saveDataInCache(CacheType type, List<T> data);
    BaseDTO getFromCache(CacheType type, Integer id) throws IOException;

}
