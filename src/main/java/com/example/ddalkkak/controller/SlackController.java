package com.example.ddalkkak.controller;

import com.example.ddalkkak.converter.response.ResponseMessage;
import com.example.ddalkkak.service.SlackService;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import com.slack.api.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/slack")
@RestController
public class SlackController {
    private final SlackService slackService;

    @GetMapping("/random")
    public List<ResponseMessage> randomMessages() {
        return slackService.getRandomChannelMessages();
    }

    @GetMapping("/learn")
    public List<ResponseMessage> learnMessages() {
        return slackService.getLearnChannelMessages();
    }

    @GetMapping("/random-all")
    public ConversationsHistoryResponse kernelMessage() {
        return slackService.getRandomAll();
    }

    @GetMapping("/learn-all")
    public ConversationsHistoryResponse learnMessage() {
        return slackService.getLearnAll();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return slackService.getUsers();
    }

    @PostMapping("/users")
    public void saveUsers() {
        slackService.saveUsers();
    }
}
