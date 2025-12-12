package com.emrednmz.mapper;

import com.emrednmz.dto.request.MessageRequest;
import com.emrednmz.dto.response.MessageResponse;
import com.emrednmz.model.Message;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {UserMapper.class, AdvertMapper.class})
public interface MessageMapper {

    Message toMessage(MessageRequest messageRequest);
    MessageResponse toMessageResponse(Message message);
}
