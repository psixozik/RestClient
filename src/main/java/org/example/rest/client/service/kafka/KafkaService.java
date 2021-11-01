package org.example.rest.client.service.kafka;

import org.example.rest.client.model.RegModelDTO;

public interface KafkaService {

    void sendRegMessage (RegModelDTO message);
}
