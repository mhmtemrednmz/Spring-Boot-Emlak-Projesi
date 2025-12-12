package com.emrednmz.service;

import com.emrednmz.dto.request.LandRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;

import java.util.List;

public interface ILandService {
    AdvertResponse saveLand(LandRequest landRequest);
    List<AdvertResponse> getAllLands();
    List<AdvertResponse> getLandByAdvertStatusType(AdvertStatusType advertStatusType);
    AdvertResponse getLandById(Long id);
    void deleteLand(Long id);
}
