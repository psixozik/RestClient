package org.example.rest.client.controller;

import org.example.rest.client.model.RegModelDTO;
import org.example.rest.client.model.RegModelRequest;
import org.example.rest.client.service.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final KafkaService kafkaService;

    @Autowired
    public RegistrationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> postResponseController(@RequestBody RegModelRequest regModelRequest) {

        kafkaService.sendRegMessage(
                RegModelDTO.builder()
                        .fullName(regModelRequest.getFullName())
                        .firstName(regModelRequest.getFirstName())
                        .secondName(regModelRequest.getSecondName())
                        .lastName(regModelRequest.getLastName())
                        .birthDate(regModelRequest.getDateOfBirthDay())
                        .build()
        );
        return ResponseEntity.ok("Запись отправлена в Kafk'у");
    }
}
