package com.example.ddalkkak.config;

import com.example.ddalkkak.converter.response.ResponseMessage;
import com.example.ddalkkak.db.model.LinkInfo;
import com.example.ddalkkak.util.Converter;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class SlackItemProcessor implements ItemProcessor<ResponseMessage, LinkInfo> {
    @Override
    public LinkInfo process(ResponseMessage item) throws Exception {
        if (item.originalUrl() == null) {
            System.out.println(item);
        }
        if (item.originalUrl()==null || urlFilter(item.originalUrl())) return null;

        return LinkInfo.of(
                item.user(),
                item.authorName(),
                item.originalUrl(),
                item.title(),
                item.thumbUrl(),
                Converter.convertTimestampToDateString(item.ts()),
                item.ts()
        );
    }

    private boolean urlFilter(String url) {
        var banLinks = List.of("https://share.coupangeats.com", "https://s.baemin.com", "https://www.baemin.com");
        for (String link : banLinks) {
            if (url.contains(link)) return true;
        }
        return false;
    }
}
