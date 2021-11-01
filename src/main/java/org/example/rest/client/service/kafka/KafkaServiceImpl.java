package org.example.rest.client.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.client.model.RegModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    private final KafkaTemplate<String, RegModelDTO> kafkaTemplate;

    @Autowired
    public KafkaServiceImpl(KafkaTemplate<String, RegModelDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRegMessage (RegModelDTO message) {
        ListenableFuture<SendResult<String, RegModelDTO>> future =
                kafkaTemplate.send(kafkaTopic, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, RegModelDTO> result) {
                log.error("Successes to send message to TOPIC: " + kafkaTopic + "| with message: " + message + "|");

            }
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
                log.error("Failed to send message to TOPIC: " + kafkaTopic + "| with message: " + message + "|");
            }
        });
    }
}
