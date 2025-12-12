package com.emrednmz.service.impl;

import com.emrednmz.dto.request.MessageRequest;
import com.emrednmz.dto.response.MessageResponse;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.mapper.MessageMapper;
import com.emrednmz.model.Message;
import com.emrednmz.repository.AdvertRepository;
import com.emrednmz.repository.MessageRepository;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdvertRepository advertRepository;

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {
        Message savedMessage = messageRepository.save(createMessage(messageRequest));
        return messageMapper.toMessageResponse(savedMessage);
    }

    @Override
    public List<MessageResponse> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageResponse> getMessagesByReceiver(Long receiverId) {
        return messageRepository.findByRecipient(receiverId).stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageResponse> getMessagesBySender(Long senderId) {
        return messageRepository.findBySender(senderId).stream()
                .map(messageMapper::toMessageResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponse getMessageById(Long id) {
        return messageRepository.findById(id)
                .map(messageMapper::toMessageResponse)
                .orElseThrow(()-> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_MESSAGE, id.toString())));
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }


    private Message createMessage(MessageRequest messageRequest) {
        Message message = messageMapper.toMessage(messageRequest);
        message.setCreateTime(new Date());

        message.setSender(userRepository.findById(messageRequest.getSender_id())
                .orElseThrow(()-> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, messageRequest.getSender_id().toString()))));

        message.setRecipient(userRepository.findById(messageRequest.getRecipient_id())
                .orElseThrow(()-> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, messageRequest.getRecipient_id().toString()))));

        message.setAdvert(advertRepository.findById(messageRequest.getAdvert_id())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, messageRequest.getAdvert_id().toString()))));

        return message;
    }
}
