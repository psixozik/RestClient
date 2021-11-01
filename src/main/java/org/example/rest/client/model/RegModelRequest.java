package org.example.rest.client.model;

import lombok.Data;

@Data
public class RegModelRequest {

    private String firstName;
    private String secondName;
    private String lastName;
    private String dateOfBirthDay;

    public String getFullName() {
        return firstName
                + (" ")
                + (secondName)
                + (" ")
                + (lastName);
    }
}
