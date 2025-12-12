package com.emrednmz.dto.response;

import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.enums.LandType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvertResponse extends BaseResponse {
    private UserResponse user;
    private AdvertStatusType advertStatusType;
    private AddressResponse address;
    private String title;
    private String description;
    private Double price;

    // Housing
    private Integer numberOfRooms;
    private Integer numberOfLounge;
    private Integer numberOfBathrooms;
    private Integer floorNumber;
    private Integer totalFloorsInBuilding;
    private Integer housingSize;
    private Integer housingAge;
    private Boolean isFurnished;

    // Land
    private Double landSize;
    private Boolean isFertile;
    private Boolean isCommercial;
    private LandType landType;
}
