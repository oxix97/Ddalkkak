package com.example.ddalkkak.util;

import com.example.ddalkkak.converter.response.ResponseMessage;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ResponseMapper {
    public List<ResponseMessage> getResponseMessages(ConversationsHistoryResponse response) {
        if (response.isOk()) {
            return response.getMessages()
                    .stream()
                    .filter(it -> it.getAttachments() != null)
                    .map(ResponseMessage::from)
                    .toList();
        } else {
            log.error("Failed to fetch messages: {}", response.getError());
        }
        return List.of();
    }
}
