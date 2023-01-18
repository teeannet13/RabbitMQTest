package com.example.rabbitmqtest.work_queues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile({"work_queues"})
@Configuration
@EnableScheduling
public class WorkQueuesConfig {

    @Bean
    public Queue hello() {
        return new Queue("work_queues");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public WorkQueuesReceiver receiver1() {
            return new WorkQueuesReceiver(1);
        }

        @Bean
        public WorkQueuesReceiver receiver2() {
            return new WorkQueuesReceiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public WorkQueuesSender sender() {
        return new WorkQueuesSender();
    }
}