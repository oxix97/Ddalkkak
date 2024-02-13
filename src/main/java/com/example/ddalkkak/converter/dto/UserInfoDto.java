package com.example.ddalkkak.converter.dto;

import com.example.ddalkkak.db.model.UserInfo;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.ddalkkak.db.model.UserInfo}
 */
public record UserInfoDto(
        String id,
        String name,
        boolean admin,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static UserInfoDto of(
            String id,
            String name,
            boolean admin
    ) {
        return UserInfoDto.of(
                id,
                name,
                admin,
                null,
                null
        );
    }

    public static UserInfoDto of(
            String id,
            String name,
            boolean admin,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new UserInfoDto(
                id,
                name,
                admin,
                createdAt,
                updatedAt
        );
    }

    public static UserInfoDto from(UserInfo entity) {
        return UserInfoDto.of(
                entity.getSlackId(),
                entity.getName(),
                entity.isAdmin(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public UserInfo toEntity() {
        return UserInfo.of(
                id,
                name,
                admin
        );
    }
}