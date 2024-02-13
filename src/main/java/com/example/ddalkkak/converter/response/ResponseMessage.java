package com.example.ddalkkak.converter.response;

import com.slack.api.model.Message;

public record ResponseMessage(
        String user,
        String authorName,
        String originalUrl,
        String title,
        String thumbUrl,
        String ts
) {
    public static ResponseMessage of(
            String user,
            String ts,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl
    ) {
        return new ResponseMessage(
                user,
                ts,
                authorName,
                originalUrl,
                title,
                thumbUrl
        );
    }

    public static ResponseMessage from(
            Message message
    ) {
        return ResponseMessage.of(
                message.getUser(),
                message.getAttachments().get(0).getAuthorName(),
                message.getAttachments().get(0).getOriginalUrl(),
                message.getAttachments().get(0).getTitle(),
                message.getAttachments().get(0).getThumbUrl(),
                message.getTs().split("\\.")[0]
        );
    }
}
