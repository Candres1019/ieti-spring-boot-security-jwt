package org.ada.school.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.ada.school.controller.user.UserDto;
import org.ada.school.exception.UserNotFoundException;
import org.ada.school.repository.UserRepository;
import org.ada.school.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceMongoDB implements UserService {

	private final UserRepository userRepository;

	@Override
	public User create(UserDto userDto) {

		return userRepository.save(new User(userDto));
	}

	@Override
	public User findById(String id) {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}

		throw new UserNotFoundException();
	}

	@Override
	public User findByEmail(String email) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findByEmail(email);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}

		throw new UserNotFoundException();
	}

	@Override
	public List<User> all() {

		return userRepository.findAll();
	}

	@Override
	public boolean deleteById(String id) {

		boolean canDelete = false;

		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			canDelete = true;
		}

		return canDelete;
	}

	@Override
	public User update(UserDto userDto, String id) {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.update(userDto);
			userRepository.save(user);
			return user;
		}

		return null;
	}

}
