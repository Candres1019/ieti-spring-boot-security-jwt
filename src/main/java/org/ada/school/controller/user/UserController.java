package org.ada.school.controller.user;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.ada.school.repository.document.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> all() {

		return ResponseEntity.ok(userService.all());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {

		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {

		return ResponseEntity.ok(userService.create(userDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {

		return ResponseEntity.ok(userService.update(userDto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		return ResponseEntity.ok(userService.deleteById(id));
	}

}
