package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestMessageController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.MessageRequest;
import com.emrednmz.dto.response.MessageResponse;
import com.emrednmz.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/message")
public class RestMessageControllerImpl extends RestBaseController implements IRestMessageController {
    @Autowired
    private IMessageService messageService;

    @PostMapping("send")
    @Override
    public RootEntity<MessageResponse> sendMessage(@RequestBody MessageRequest messageRequest) {
        return ok(messageService.sendMessage(messageRequest));
    }

    @GetMapping
    @Override
    public RootEntity<List<MessageResponse>> getAllMessages() {
        return ok(messageService.getAllMessages());
    }

    @GetMapping("received-message/{receiverId}")
    @Override
    public RootEntity<List<MessageResponse>> getMessagesByReceiver(@PathVariable Long receiverId) {
        return ok(messageService.getMessagesByReceiver(receiverId));
    }

    @GetMapping("sent-message/{senderId}")
    @Override
    public RootEntity<List<MessageResponse>> getMessagesBySender(@PathVariable Long senderId) {
        return ok(messageService.getMessagesBySender(senderId));
    }

    @GetMapping("{id}")
    @Override
    public RootEntity<MessageResponse> getMessageById(@PathVariable Long id) {
        return ok(messageService.getMessageById(id));
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
    }
}
