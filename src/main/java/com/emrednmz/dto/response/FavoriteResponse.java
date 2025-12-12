package com.emrednmz.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteResponse extends BaseResponse {
    private UserResponse user;
    private AdvertResponse advert;
}
