package com.example.DoctorDetail.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.DoctorDetail.Dto.StatusConsumerDto;


@Service
public class StatusConsumer {


    private static final Logger log =
            LoggerFactory.getLogger(StatusConsumer.class);
    @KafkaListener(
        topics = "${spring.kafka.topic.name}",
        groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(StatusConsumerDto dto) {
log.info("SucessFully");
        System.out.println("Received from Kafka: " + dto.getStatus());
    }
}
