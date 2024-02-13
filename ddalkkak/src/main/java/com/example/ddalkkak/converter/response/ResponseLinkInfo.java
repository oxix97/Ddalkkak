package com.example.ddalkkak.converter.response;

import com.example.ddalkkak.converter.dto.LinkInfoDto;
import com.example.ddalkkak.converter.dto.UserInfoDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseLinkInfo(
        Long id,
        String user,
        String username,
        Boolean admin,
        String authorName,
        String originalUrl,
        String title,
        String thumbUrl,
        LocalDate slackCreatedAt,
        String ts,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ResponseLinkInfo of(Object[] obj) {
        return ResponseLinkInfo.of(
                (Long) obj[0],
                (String) obj[1],
                (String) obj[2],
                (Boolean) obj[3],
                (String) obj[4],
                (String) obj[5],
                (String) obj[6],
                (String) obj[7],
                (LocalDate) obj[8],
                (String) obj[9],
                (LocalDateTime) obj[10],
                (LocalDateTime) obj[11]
        );
    }

    public static ResponseLinkInfo of(
            Long id,
            String user,
            String username,
            Boolean admin,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl,
            LocalDate slackCreatedAt,
            String ts,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new ResponseLinkInfo(
                id,
                user,
                username,
                admin,
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

    public static ResponseLinkInfo of(LinkInfoDto linkInfoDto, UserInfoDto userInfoDto) {
        return ResponseLinkInfo.of(
                linkInfoDto.id(),
                linkInfoDto.user(),
                userInfoDto.name(),
                userInfoDto.admin(),
                linkInfoDto.authorName(),
                linkInfoDto.originalUrl(),
                linkInfoDto.title(),
                linkInfoDto.thumbUrl(),
                linkInfoDto.slackCreatedAt(),
                linkInfoDto.ts(),
                linkInfoDto.createdAt(),
                linkInfoDto.updatedAt()
        );
    }
}
