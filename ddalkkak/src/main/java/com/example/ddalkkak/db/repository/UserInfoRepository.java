package com.example.ddalkkak.db.repository;

import com.example.ddalkkak.db.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByName(String name);
}
