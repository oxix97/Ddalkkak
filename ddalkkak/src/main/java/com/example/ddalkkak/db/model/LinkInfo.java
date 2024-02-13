package com.example.ddalkkak.db.model;

import com.example.ddalkkak.converter.dto.AuditingField;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
public class LinkInfo extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user;

    private String authorName;

    @Column(length = 3000)
    private String originalUrl;

    @Column(length = 3000)
    private String title;

    @Column(length = 3000)
    private String thumbUrl;

    @Column(nullable = false)
    private LocalDate slackCreatedAt;

    @Column(nullable = false, unique = true)
    private String ts;

    public static LinkInfo of(
            String user,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl,
            LocalDate slackCreatedAt,
            String ts
    ) {
        return new LinkInfo(
                user,
                authorName,
                originalUrl,
                title,
                thumbUrl,
                slackCreatedAt,
                ts
        );
    }

    private LinkInfo(
            String user,
            String authorName,
            String originalUrl,
            String title,
            String thumbUrl,
            LocalDate slackCreatedAt,
            String ts
    ) {
        this.user = user;
        this.authorName = authorName;
        this.originalUrl = originalUrl;
        this.title = title;
        this.thumbUrl = thumbUrl;
        this.slackCreatedAt = slackCreatedAt;
        this.ts = ts;
    }
}
