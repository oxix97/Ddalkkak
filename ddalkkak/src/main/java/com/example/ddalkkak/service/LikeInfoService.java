package com.example.ddalkkak.service;

import com.example.ddalkkak.converter.dto.LikeInfoDto;
import com.example.ddalkkak.db.model.LikeInfo;
import com.example.ddalkkak.db.repository.LikeInfoRepository;
import com.example.ddalkkak.db.repository.LinkInfoRepository;
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
public class LikeInfoService {
    private final LinkInfoRepository linkInfoRepository;
    private final LikeInfoRepository likeInfoRepository;
    private final UserInfoRepository userInfoRepository;

    public void putLike(Long linkId, Long userId) {
        var user = userInfoRepository.getReferenceById(userId);
        var link = linkInfoRepository.getReferenceById(linkId);
        likeInfoRepository.save(LikeInfo.of(user, link));
    }

    public void deleteLike(Long likeId) {
        likeInfoRepository.deleteById(likeId);
    }

    public List<LikeInfoDto> getLikes(Long userId) {
        var user = userInfoRepository.getReferenceById(userId);
        return likeInfoRepository.findAllByUserInfo(user)
                .stream()
                .map(LikeInfoDto::from)
                .toList();
    }
}
