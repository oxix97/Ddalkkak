package com.example.ddalkkak.db.repository;

import com.example.ddalkkak.db.model.LikeInfo;
import com.example.ddalkkak.db.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeInfoRepository extends JpaRepository<LikeInfo, Long> {
    List<LikeInfo> findAllByUserInfo(UserInfo userInfo);
}
