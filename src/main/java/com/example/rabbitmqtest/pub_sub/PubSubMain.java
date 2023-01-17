package com.example.rabbitmqtest.pub_sub;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("pub_sub")
public class PubSubMain implements CommandLineRunner {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;   // configured in Tut3Config above

    @Override
    public void run(String... args) throws Exception {
        template.convertAndSend(fanout.getName(), "", "Message from pub_sub");
    }
}
