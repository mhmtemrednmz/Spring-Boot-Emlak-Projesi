package com.emrednmz.dto.request;

import com.emrednmz.enums.AdvertStatusType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HousingRequest {
    private Long user_id;
    private AdvertStatusType advertStatusType;
    private Long address_id;
    private String title;
    private String description;
    private Double price;

    private int numberOfRooms;
    private int numberOfLounge;
    private int numberOfBathrooms;
    private int floorNumber;
    private int totalFloorsInBuilding;
    private int housingSize;
    private int housingAge;
    private boolean furnished;
}
