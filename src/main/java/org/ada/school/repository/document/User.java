package org.ada.school.repository.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ada.school.controller.user.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter
@Document
@NoArgsConstructor
public class User {

	@Id
	String id;

	String name;

	String lastName;

	@Indexed(unique = true)
	String email;

	String passwordHash;

	List<RoleEnum> roles;

	Date createdAt;

	public User(UserDto userDto) {

		name = userDto.getName();
		lastName = userDto.getLastName();
		email = userDto.getEmail();
		createdAt = new Date();
		roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
		passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
	}

	public void update(UserDto userDto) {

		this.name = userDto.getName();
		this.lastName = userDto.getLastName();
		this.email = userDto.getEmail();
		if (userDto.getPassword() != null) {
			this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
		}
	}

}

