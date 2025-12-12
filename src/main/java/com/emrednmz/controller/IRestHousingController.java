package com.emrednmz.controller;

import com.emrednmz.dto.request.HousingRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;

import java.util.List;

public interface IRestHousingController {
    RootEntity<AdvertResponse> saveHousing(HousingRequest housingRequest);
    RootEntity<List<AdvertResponse>> getAllHousing();
    RootEntity<List<AdvertResponse>> getHousingByAdvertStatusType(AdvertStatusType advertStatusType);
    RootEntity<AdvertResponse> getHousingById(Long id);;
    void deleteHousingById(Long id);
}
