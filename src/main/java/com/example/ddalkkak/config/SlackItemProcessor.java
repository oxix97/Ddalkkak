package com.example.ddalkkak.config;

import com.example.ddalkkak.converter.response.ResponseMessage;
import com.example.ddalkkak.db.model.LinkInfo;
import com.example.ddalkkak.util.Converter;
import org.springframework.batch.item.ItemProcessor;

public class SlackItemProcessor implements ItemProcessor<ResponseMessage, LinkInfo> {
    @Override
    public LinkInfo process(ResponseMessage item) throws Exception {
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
}
