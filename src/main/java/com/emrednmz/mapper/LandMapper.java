package com.emrednmz.mapper;

import com.emrednmz.dto.request.LandRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.model.Land;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LandMapper {
    Land toLand(LandRequest landRequest);
    AdvertResponse toAdvertResponse(Land land);
}
