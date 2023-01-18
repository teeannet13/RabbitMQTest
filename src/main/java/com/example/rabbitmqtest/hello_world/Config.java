package com.example.rabbitmqtest.hello_world;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile({"hello_world"})
@Configuration
@EnableScheduling
public class Config {
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public HelloWorldReceiver receiver() {
        return new HelloWorldReceiver();
    }

    @Profile("sender")
    @Bean
    public HelloWorldSender sender() {
        return new HelloWorldSender();
    }
}
