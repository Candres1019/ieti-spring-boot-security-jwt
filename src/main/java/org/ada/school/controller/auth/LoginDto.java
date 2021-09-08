package org.ada.school.controller.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginDto {

	private final String email;

	private final String password;

}
