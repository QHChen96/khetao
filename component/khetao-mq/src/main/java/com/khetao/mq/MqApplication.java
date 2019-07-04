package com.khetao.mq;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Collections;

/**
 * <p>
 *  消息队列
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-04
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void in(String in, @Header(KafkaHeaders.CONSUMER) Consumer<?, ?> consumer) {
        System.out.println(in);
        consumer.pause(Collections.singleton(new TopicPartition("myTopic", 0)));
    }

    @Bean
    public ApplicationListener<ListenerContainerIdleEvent> idleListener() {
        return event -> {
            System.out.println(event);
            if (event.getConsumer().paused().size() > 0) {
                event.getConsumer().resume(event.getConsumer().paused());
            }
        };
    }

}
