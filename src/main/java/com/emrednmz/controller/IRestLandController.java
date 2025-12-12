package com.emrednmz.controller;

import com.emrednmz.dto.request.LandRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;

import java.util.List;

public interface IRestLandController {
    RootEntity<AdvertResponse> saveLand(LandRequest landRequest);
    RootEntity<List<AdvertResponse>> getAllLands();
    RootEntity<List<AdvertResponse>> getLandByAdvertStatusType(AdvertStatusType advertStatusType);
    RootEntity<AdvertResponse> getLandById(Long id);
    void deleteLandById(Long id);
}
