package com.emrednmz.service;

import com.emrednmz.dto.request.MessageRequest;
import com.emrednmz.dto.response.MessageResponse;

import java.util.List;

public interface IMessageService {
    MessageResponse sendMessage(MessageRequest messageRequest);
    List<MessageResponse> getAllMessages();
    List<MessageResponse> getMessagesByReceiver(Long receiverId);
    List<MessageResponse> getMessagesBySender(Long senderId);
    MessageResponse getMessageById(Long id);
    void deleteMessageById(Long id);
}
