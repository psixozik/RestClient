package org.example.rest.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegModelDTO {

    private String fullName;
    private String firstName;
    private String secondName;
    private String lastName;
    private String birthDate;

}
