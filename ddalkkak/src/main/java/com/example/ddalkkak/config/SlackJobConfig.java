package com.example.ddalkkak.config;

import com.example.ddalkkak.converter.response.ResponseMessage;
import com.example.ddalkkak.db.model.LinkInfo;
import com.example.ddalkkak.service.SlackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SlackJobConfig {
    private final JobRepository jobRepository;
    private final JobCompletionNotificationListener listener;
    private final PlatformTransactionManager transactionManager;
    private final DataSource dataSource;
    private final SlackService slackService;

    @Bean
    public Job job() throws Exception {
        return new JobBuilder("job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step())
                .build();
    }

    @Bean
    public Step step() throws Exception {
        return new StepBuilder("step", jobRepository)
                .<ResponseMessage, LinkInfo>chunk(100, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public SlackItemReader itemReader() {
        return new SlackItemReader(getItems());
    }

    @Bean
    public SlackItemProcessor itemProcessor() {
        return new SlackItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<LinkInfo> itemWriter() {
        return new JdbcBatchItemWriterBuilder<LinkInfo>()
                .dataSource(dataSource)
                .sql("INSERT INTO link_info (user, author_name, original_url, thumb_url, title, slack_created_at, ts, created_at, updated_at) " +
                        "VALUES (:user, :authorName, :originalUrl, :thumbUrl, :title, :slackCreatedAt, :ts, now(), now()) " +
                        "ON DUPLICATE KEY UPDATE " +
                        "author_name = :authorName, " +
                        "original_url = :originalUrl, " +
                        "thumb_url = :thumbUrl, " +
                        "title = :title, " +
                        "user = :user, " +
                        "updated_at = now()")
                .beanMapped()
                .build();
    }

    private List<ResponseMessage> getItems() {
        List<ResponseMessage> items = new ArrayList<>();
        var randoms = slackService.getRandomChannelMessages();
        var learns = slackService.getLearnChannelMessages();
        items.addAll(randoms);
        items.addAll(learns);
        return items;
    }
}
