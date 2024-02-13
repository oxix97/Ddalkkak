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
@EntityListeners(AuditingEntityListener.class)
@Entity
public class LikeInfo extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserInfo userInfo;

    @ManyToOne
    private LinkInfo linkInfo;

    public static LikeInfo of(UserInfo userInfo, LinkInfo linkInfo) {
        return new LikeInfo(userInfo, linkInfo);
    }

    private LikeInfo(UserInfo userInfo, LinkInfo linkInfo) {
        this.userInfo = userInfo;
        this.linkInfo = linkInfo;
    }
}
