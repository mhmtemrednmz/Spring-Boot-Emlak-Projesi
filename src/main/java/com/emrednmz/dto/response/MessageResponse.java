package com.emrednmz.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse extends BaseResponse {
    private UserResponse sender;
    private UserResponse recipient;
    private AdvertResponse advert;
    private String message;
}
