package com.example.AdminDetail.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.AdminDetail.Dto.statusUpdation;

@Service
public class StatusProducer {

	 @Value("${kafka.topic.name}")
	    private String topicName;

	    private final KafkaTemplate<String, statusUpdation> kafkaTemplate;

	    public StatusProducer(KafkaTemplate<String, statusUpdation> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendMessage(statusUpdation event) {
	        kafkaTemplate.send(topicName, event);
	    }
	
	
}
