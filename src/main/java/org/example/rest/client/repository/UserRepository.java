package org.example.rest.client.repository;

import org.example.rest.client.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel getById(String id);
}
