package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("local") // we are not supposed to create topic in dev or prod env
// all in all it is not recommended creating topic(s) programmatically
public class AutoCreateConfig {
    @Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("library-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

}
