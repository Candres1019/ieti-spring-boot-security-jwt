package org.ada.school.controller.auth;

import static org.ada.school.utils.Constants.CLAIMS_ROLES_KEY;
import static org.ada.school.utils.Constants.TOKEN_DURATION_MINUTES;

import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.ada.school.exception.InvalidCredentialsException;
import org.ada.school.repository.document.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

	private final UserService userService;

	@Value("${app.secret}")
	String secret;

	@PostMapping
	public TokenDto login(@RequestBody LoginDto loginDto) {

		User user = userService.findByEmail(loginDto.getEmail());
		if (BCrypt.checkpw(loginDto.getPassword(), user.getPasswordHash())) {
			return generateTokenDto(user);
		} else {
			throw new InvalidCredentialsException();
		}

	}

	private String generateToken(User user, Date expirationDate) {

		return Jwts.builder()
				   .setSubject(user.getId())
				   .claim(CLAIMS_ROLES_KEY, user.getRoles())
				   .setIssuedAt(new Date())
				   .setExpiration(expirationDate)
				   .signWith(SignatureAlgorithm.HS256, secret)
				   .compact();
	}

	private TokenDto generateTokenDto(User user) {

		Calendar expirationDate = Calendar.getInstance();
		expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
		String token = generateToken(user, expirationDate.getTime());
		return new TokenDto(token, expirationDate.getTime());
	}
}
