package org.ada.school.controller.auth;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenDto {

	private final String token;

	private final Date expirationDate;

}
