package com.example.ddalkkak.config;

import com.example.ddalkkak.converter.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class SlackItemReader implements ItemReader<ResponseMessage> {
    private final List<ResponseMessage> items;
    @Override
    public ResponseMessage read() throws Exception {
        if(!items.isEmpty()) {
            log.info("item : {}", items);
            return items.remove(0);
        }
        return null;
    }
}
