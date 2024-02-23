package com.example.ddalkkak.converter.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.api.model.Attachment;
import com.slack.api.model.Message;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.RichTextBlock;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
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
        var attachment = message.getAttachments().get(0);
        String url = urlParser(attachment);
        return ResponseMessage.of(
                message.getUser(),
                attachment.getAuthorName(),
                url,
                attachment.getTitle(),
                attachment.getThumbUrl(),
                message.getTs()
        );
    }

    private static String urlParser(Attachment attachment) {
        if (attachment.getTitleLink() == null) return attachment.getAppUnfurlUrl();
        return attachment.getTitleLink();
    }
}