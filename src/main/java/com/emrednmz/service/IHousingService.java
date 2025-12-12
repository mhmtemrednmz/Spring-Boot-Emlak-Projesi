package com.emrednmz.service;

import com.emrednmz.dto.request.HousingRequest;
import com.emrednmz.dto.response.AddressResponse;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;

import java.util.List;

public interface IHousingService {
    AdvertResponse saveHousing(HousingRequest housingRequest);
    List<AdvertResponse> getAllHousing();
    List<AdvertResponse> getHousingByAdvertStatusType(AdvertStatusType advertStatusType);
    AdvertResponse getHousingById(Long id);
    void deleteHousingById(Long id);
}
