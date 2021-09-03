package org.ada.school.service;

import java.util.List;

import org.ada.school.controller.user.UserDto;
import org.ada.school.exception.UserNotFoundException;
import org.ada.school.repository.document.User;

public interface UserService {

	User create(UserDto userDto);

	User findById(String id) throws UserNotFoundException;

	User findByEmail(String email) throws UserNotFoundException;

	List<User> all();

	boolean deleteById(String id);

	User update(UserDto userDto, String id);
}
