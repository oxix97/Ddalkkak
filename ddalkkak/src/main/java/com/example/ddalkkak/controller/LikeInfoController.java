package com.example.ddalkkak.controller;

import com.example.ddalkkak.converter.response.ResponseLinkInfo;
import com.example.ddalkkak.db.model.LikeInfo;
import com.example.ddalkkak.service.LikeInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.Like;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/likes")
@RestController
public class LikeInfoController {
    private final LikeInfoService likeInfoService;

    @PutMapping
    public void putLike(
            @RequestParam Long linkId,
            @RequestParam Long userId
    ) {
        likeInfoService.putLike(linkId, userId);
    }

    @DeleteMapping
    public void deleteLike(
            @RequestParam Long likeId
    ) {
        likeInfoService.deleteLike(likeId);
    }

    @GetMapping("/{userId}")
    public List<ResponseLinkInfo> getLikes(
            @PathVariable Long userId
    ) {
        return likeInfoService.getLikes(userId)
                .stream()
                .map(it -> ResponseLinkInfo.of(it.linkInfo(), it.userInfo()))
                .toList();
    }
}
