package com.example.ddalkkak.util;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.conversations.ConversationsHistoryRequest;
import com.slack.api.methods.request.users.UsersListRequest;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import com.slack.api.methods.response.users.UsersListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SlackClient {
    @Value(value = "${slack.token}")
    private String KERNEL_TOKEN;
    @Value("${slack.team}")
    public String TEAM_ID;

    public ConversationsHistoryResponse getRandomHistory(int limit) {
        return getChannelHistory(Channel.RANDOM, limit);
    }

    public ConversationsHistoryResponse getLearnHistory(int limit) {
        return getChannelHistory(Channel.LEARN, limit);
    }

    public ConversationsHistoryResponse getSpringMentorHistory(int limit) {
        return getChannelHistory(Channel.MENTORING, limit);
    }

    public UsersListResponse getGroupUsers() {
        try {
            MethodsClient methods = Slack.getInstance()
                    .methods(KERNEL_TOKEN);
            UsersListRequest request = UsersListRequest.builder()
                    .token(KERNEL_TOKEN)
                    .teamId(TEAM_ID)
                    .limit(1000)
                    .build();
            return methods.usersList(request);
        } catch (Exception e) {
            log.error("Failed to fetch messages: {}", e.getMessage());
        }
        return null;
    }

    private ConversationsHistoryResponse getChannelHistory(String channelId, int limit) {
        try {
            MethodsClient methods = Slack.getInstance()
                    .methods(KERNEL_TOKEN);
            ConversationsHistoryRequest request = ConversationsHistoryRequest.builder()
                    .token(KERNEL_TOKEN)
                    .channel(channelId) // #random 채널 ID
                    .limit(limit)
                    .build();
            return methods.conversationsHistory(request);
        } catch (Exception e) {
            log.error("Failed to fetch messages: {}", e.getMessage());
        }
        return null;
    }
}
