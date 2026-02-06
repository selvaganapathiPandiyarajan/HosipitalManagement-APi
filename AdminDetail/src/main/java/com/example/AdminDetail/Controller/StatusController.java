package com.example.AdminDetail.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdminDetail.Dto.statusUpdation;
import com.example.AdminDetail.kafka.StatusProducer;


@RestController
@RequestMapping("/admin")
public class StatusController {

    private static final Logger log =
            LoggerFactory.getLogger(StatusController.class);

    private final StatusProducer statusproducer;

    public StatusController(StatusProducer statusproducer) {
        this.statusproducer = statusproducer;
    }

    @PostMapping("/status")
    public String changeStatus(@RequestBody statusUpdation statusupdation) {

        statusupdation.setStatus("Pending");

        log.info("Before sending to Kafka: {}", statusupdation);

        statusproducer.sendMessage(statusupdation);

        log.info("After sending to Kafka");

        return "Successfully changed status";
    }
}
