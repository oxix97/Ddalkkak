package com.example.ddalkkak.controller;

import com.example.ddalkkak.converter.dto.UserInfoDto;
import com.example.ddalkkak.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserInfoDto getUser(
            @PathVariable String userId
    ) {
        return userService.getUser(userId);
    }

    @GetMapping
    public List<UserInfoDto> getUsers() {
        return userService.getUsers();
    }
}
