package com.example.ddalkkak.service;

import com.example.ddalkkak.converter.dto.UserInfoDto;
import com.example.ddalkkak.converter.response.ResponseMessage;
import com.example.ddalkkak.db.repository.UserInfoRepository;
import com.example.ddalkkak.util.SlackClient;
import com.example.ddalkkak.util.ResponseMapper;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import com.slack.api.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class SlackService {
    private final SlackClient slackClient;
    private final ResponseMapper responseMapper;
    private final UserInfoRepository userInfoRepository;

    public List<ResponseMessage> getRandomChannelMessages() {
        var response = slackClient.getRandomHistory(20);
        return responseMapper.getResponseMessages(response);
    }

    public List<ResponseMessage> getLearnChannelMessages() {
        var response = slackClient.getLearnHistory(20);
        return responseMapper.getResponseMessages(response);
    }

    public ConversationsHistoryResponse getRandomAll() {
        return slackClient.getRandomHistory(1000);
    }

    public ConversationsHistoryResponse getLearnAll() {
        return slackClient.getLearnHistory(1000);
    }

    public List<User> getUsers() {
        return slackClient.getGroupUsers()
                .getMembers()
                .stream()
                .filter(user -> !user.isDeleted())
                .filter(user -> !user.getProfile()
                        .getDisplayName()
                        .isEmpty())
                .toList();
    }

    public void saveUsers() {
        slackClient.getGroupUsers()
                .getMembers()
                .stream()
                .filter(user -> !user.isDeleted())
                .filter(user -> !user.getProfile()
                        .getDisplayName()
                        .isEmpty())
                .map(it -> UserInfoDto.of(it.getId(), it.getProfile()
                        .getDisplayName(), it.isAdmin()))
                .map(UserInfoDto::toEntity)
                .forEach(userInfoRepository::save);
    }
}


