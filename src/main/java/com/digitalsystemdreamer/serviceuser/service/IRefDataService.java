package com.digitalsystemdreamer.serviceuser.service;

import com.digitalsystemdreamer.serviceuser.cache.CacheType;

import java.io.IOException;
import java.util.List;

public interface IRefDataService {

    <T> List<T> saveDataInCache(CacheType type, List<T> data);
    <T> List<T> getFromCache(CacheType type) throws IOException;

}
