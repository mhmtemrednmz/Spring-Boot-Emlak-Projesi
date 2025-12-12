package com.emrednmz.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse extends BaseResponse {
    private String city;
    private String district;
    private String neighborhood;
    private String street;
}
