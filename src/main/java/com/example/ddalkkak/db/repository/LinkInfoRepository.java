package com.example.ddalkkak.db.repository;

import com.example.ddalkkak.db.model.LinkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LinkInfoRepository extends JpaRepository<LinkInfo, Long> {
    List<LinkInfo> findByUser(String user);

    List<LinkInfo> findAllByOrderBySlackCreatedAtDesc();

    List<LinkInfo> findBySlackCreatedAt(LocalDate slackCreatedAt);

}
