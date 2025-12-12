package com.emrednmz.dto.request;

import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.enums.LandType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandRequest {
    private Long user_id;
    private AdvertStatusType advertStatusType;
    private Long address_id;
    private String title;
    private String description;
    private Double price;

    private double landSize;
    private boolean isFertile;
    private boolean isCommercial;
    private LandType landType;
}
