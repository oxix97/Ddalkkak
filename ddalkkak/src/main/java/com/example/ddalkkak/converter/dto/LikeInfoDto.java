package com.example.ddalkkak.converter.dto;

import com.example.ddalkkak.db.model.LikeInfo;
import com.example.ddalkkak.db.model.LinkInfo;
import com.example.ddalkkak.db.model.UserInfo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.ddalkkak.db.model.LikeInfo}
 */
public record LikeInfoDto(
        Long id,
        UserInfoDto userInfo,
        LinkInfoDto linkInfo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static LikeInfoDto of(
            Long id,
            UserInfoDto userInfo,
            LinkInfoDto linkInfo,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new LikeInfoDto(
                id,
                userInfo,
                linkInfo,
                createdAt,
                updatedAt
        );
    }

    public static LikeInfoDto from(LikeInfo entity) {
        return LikeInfoDto.of(
                entity.getId(),
                UserInfoDto.from(entity.getUserInfo()),
                LinkInfoDto.from(entity.getLinkInfo()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public LikeInfo toEntity(UserInfo userInfo, LinkInfo linkInfo) {
        return LikeInfo.of(
                userInfo,
                linkInfo
        );
    }
}