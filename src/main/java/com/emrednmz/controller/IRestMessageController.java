package com.emrednmz.controller;

import com.emrednmz.dto.request.MessageRequest;
import com.emrednmz.dto.response.MessageResponse;

import java.util.List;

public interface IRestMessageController {
    RootEntity<MessageResponse> sendMessage(MessageRequest messageRequest);
    RootEntity<List<MessageResponse>> getAllMessages();
    RootEntity<List<MessageResponse>> getMessagesByReceiver(Long receiverId);
    RootEntity<List<MessageResponse>> getMessagesBySender(Long senderId);
    RootEntity<MessageResponse> getMessageById(Long id);
    void deleteMessage(Long id);
}
