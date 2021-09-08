package org.ada.school.repository;

import java.util.Optional;

import org.ada.school.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByEmail(String email);
}
