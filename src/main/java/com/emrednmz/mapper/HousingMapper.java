package com.emrednmz.mapper;

import com.emrednmz.dto.request.HousingRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.model.Housing;
import com.emrednmz.enums.AdvertStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface HousingMapper {
    Housing toHousing(HousingRequest housingRequest);
    AdvertResponse toAdvertResponse(Housing housing);

}
