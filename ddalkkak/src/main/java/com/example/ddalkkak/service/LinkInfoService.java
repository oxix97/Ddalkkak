package com.example.ddalkkak.service;

import com.example.ddalkkak.converter.dto.LinkInfoDto;
import com.example.ddalkkak.db.model.LinkInfo;
import com.example.ddalkkak.db.repository.LinkInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LinkInfoService {
    private final LinkInfoRepository linkInfoRepository;

    public LinkInfoDto getLink(String ts) {
        return LinkInfoDto.from(linkInfoRepository.findByTs(ts));
    }

    public List<LinkInfoDto> getLinks() {
        return linkInfoRepository.findAllByOrderBySlackCreatedAtDesc()
                .stream()
                .map(LinkInfoDto::from)
                .toList();
    }

    public List<LinkInfoDto> getLinksByUser(String user) {
        return linkInfoRepository.findByUser(user)
                .stream()
                .map(LinkInfoDto::from)
                .toList();
    }

    public List<Object[]> getUserAndLinkInfos() {
        return linkInfoRepository.findByLinkInfos();
    }

    public List<LinkInfoDto> getLinksByCreatedAt(LocalDate createdAt) {
        return linkInfoRepository.findBySlackCreatedAt(createdAt)
                .stream()
                .map(LinkInfoDto::from)
                .toList();
    }

    public List<LocalDate> getCreatedAts() {
        return linkInfoRepository.findAll()
                .stream()
                .map(LinkInfo::getSlackCreatedAt)
                .toList();
    }

    public List<Object[]> getSearchLinkInfos(String keyword) {
        return linkInfoRepository.findBySearchInfos(keyword);
    }
}
