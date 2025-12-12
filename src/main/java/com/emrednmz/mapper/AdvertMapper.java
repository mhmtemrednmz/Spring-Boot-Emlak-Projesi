package com.emrednmz.mapper;

import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.model.Advert;
import com.emrednmz.model.Housing;
import com.emrednmz.model.Land;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {UserMapper.class, AddressMapper.class})
public interface AdvertMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "address", source = "address")
    AdvertResponse baseAdvertToAdvertResponse(Advert advert);

    @AfterMapping
    default void enrichAdvertResponse(@MappingTarget AdvertResponse response, Advert advert) {
        if (advert instanceof Housing housing) {
            response.setNumberOfRooms(housing.getNumberOfRooms());
            response.setNumberOfLounge(housing.getNumberOfLounge());
            response.setNumberOfBathrooms(housing.getNumberOfBathrooms());
            response.setFloorNumber(housing.getFloorNumber());
            response.setTotalFloorsInBuilding(housing.getTotalFloorsInBuilding());
            response.setHousingSize(housing.getHousingSize());
            response.setHousingAge(housing.getHousingAge());
            response.setIsFurnished(housing.isFurnished());
        } else if (advert instanceof Land land) {
            response.setLandSize(land.getLandSize());
            response.setIsFertile(land.isFertile());
            response.setIsCommercial(land.isCommercial());
            response.setLandType(land.getLandType());
        }
    }

}
