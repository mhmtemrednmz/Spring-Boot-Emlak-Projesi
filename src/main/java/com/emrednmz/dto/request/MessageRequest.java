package com.emrednmz.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
    private Long sender_id;
    private Long recipient_id;
    private Long advert_id;
    private String message;
}

