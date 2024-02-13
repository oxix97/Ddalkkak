package com.example.ddalkkak.converter.dto;

import com.example.ddalkkak.db.model.LinkInfo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.ddalkkak.db.model.LinkInfo}
 */
public record LinkInfoDto(
        Long id,
        String user,
        String authorName,
        String originalUrl,
        String title,
        String thumbUrl,
        LocalDate slackCreatedAt,
        String ts,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static LinkInfoDto of(
            Long id,
            String user,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl,
            LocalDate slackCreatedAt,
            String ts,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new LinkInfoDto(
                id,
                user,
                authorName,
                originalUrl,
                title,
                thumbUrl,
                slackCreatedAt,
                ts,
                createdAt,
                updatedAt
        );
    }

    public static LinkInfoDto of(
            String user,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl,
            LocalDate slackCreatedAt,
            String ts
    ) {
        return LinkInfoDto.of(
                null,
                user,
                authorName,
                originalUrl,
                title,
                thumbUrl,
                slackCreatedAt,
                ts,
                null,
                null
        );
    }

    public static LinkInfoDto from(
            LinkInfo entity
    ) {
        return LinkInfoDto.of(
                entity.getId(),
                entity.getUser(),
                entity.getAuthorName(),
                entity.getOriginalUrl(),
                entity.getTitle(),
                entity.getThumbUrl(),
                entity.getSlackCreatedAt(),
                entity.getTs(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}