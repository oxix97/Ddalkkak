package com.example.ddalkkak.controller;

import com.example.ddalkkak.converter.dto.LinkInfoDto;
import com.example.ddalkkak.converter.response.ResponseLinkInfo;
import com.example.ddalkkak.service.LinkInfoService;
import com.example.ddalkkak.util.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/link-info")
@RestController
public class LinkInfoController {
    private final LinkInfoService linkInfoService;

    @GetMapping("/ts/{ts}")
    public LinkInfoDto getLink(
            @PathVariable String ts
    ) {
        return linkInfoService.getLink(ts);
    }

    @GetMapping("/all")
    public List<ResponseLinkInfo> getLinks() {
        return linkInfoService.getUserAndLinkInfos()
                .stream()
                .map(ResponseLinkInfo::of)
                .sorted(Comparator.comparing(ResponseLinkInfo::slackCreatedAt)
                        .reversed())
                .toList();
    }

    @GetMapping("/{user}")
    public List<LinkInfoDto> getLinksByUser(
            @PathVariable String user
    ) {
        return linkInfoService.getLinksByUser(user);
    }

    @GetMapping
    public List<LinkInfoDto> getLinksByCreatedAt(
            @RequestParam String created
    ) {
        LocalDate date = Converter.convertStringToLocalDate(created);
        return linkInfoService.getLinksByCreatedAt(date);
    }

    @GetMapping("/created/all")
    public List<LocalDate> getCreatedAts() {
        return linkInfoService.getCreatedAts();
    }
}
