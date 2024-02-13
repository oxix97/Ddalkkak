package com.example.ddalkkak.controller;

import com.example.ddalkkak.converter.dto.LinkInfoDto;
import com.example.ddalkkak.service.LinkInfoService;
import com.example.ddalkkak.util.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/link-info")
@RestController
public class LinkInfoController {
    private final LinkInfoService linkInfoService;

    @GetMapping("/all")
    public List<LinkInfoDto> getLinks() {
        return linkInfoService.getLinks();
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
}
