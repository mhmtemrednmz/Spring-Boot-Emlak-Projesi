package com.emrednmz.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseResponse {
    private Long id;
    private Date createTime;
}
