package com.example.ddalkkak.service;

import com.example.ddalkkak.converter.dto.UserInfoDto;
import com.example.ddalkkak.db.model.UserInfo;
import com.example.ddalkkak.db.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoDto getUser(String userId) {
        UserInfo user = userInfoRepository.findByName(userId);
        return UserInfoDto.from(user);
    }

    public List<UserInfoDto> getUsers() {
        return userInfoRepository.findAll()
                .stream()
                .map(UserInfoDto::from)
                .toList();
    }
}
