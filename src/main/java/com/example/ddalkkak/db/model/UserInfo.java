package com.example.ddalkkak.db.model;

import com.example.ddalkkak.converter.dto.AuditingField;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Slf4j
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
public class UserInfo extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String slackId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean admin;

    public static UserInfo of(String slackId, String name, boolean admin) {
        return new UserInfo(slackId, name, admin);
    }

    public UserInfo(String slackId, String name, boolean admin) {
        this.slackId = slackId;
        this.name = name;
        this.admin = admin;
    }
}