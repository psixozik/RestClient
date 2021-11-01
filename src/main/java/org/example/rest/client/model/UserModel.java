package org.example.rest.client.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Document(collection = "usermodel")
public class UserModel extends RegModelDTO {

    @Id
    private String id;

    public UserModel(String fullName, String firstName,
                     String secondName, String lastName,
                     String birthDate, String id) {
        super(fullName, firstName, secondName, lastName, birthDate);
        this.id = id;
    }
}
