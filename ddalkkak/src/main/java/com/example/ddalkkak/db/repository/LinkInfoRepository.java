package com.example.ddalkkak.db.repository;

import com.example.ddalkkak.db.model.LinkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LinkInfoRepository extends JpaRepository<LinkInfo, Long> {
    List<LinkInfo> findByUser(String user);

    List<LinkInfo> findAllByOrderBySlackCreatedAtDesc();

    List<LinkInfo> findBySlackCreatedAt(LocalDate slackCreatedAt);

    LinkInfo findByTs(String ts);

    @Modifying
    @Query("select l.id, l.user, u.name, u.admin, l.authorName, " +
            "l.originalUrl, l.title, l.thumbUrl, l.slackCreatedAt, " +
            "l.ts, l.createdAt, l.updatedAt " +
            "from LinkInfo l, UserInfo u where l.user=u.slackId")
    List<Object[]> findByLinkInfos();
}
