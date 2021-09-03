package org.ada.school.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ada.school.error.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

@Getter
public class ServerErrorResponseDto {

	private final String message;

    private final ErrorCodeEnum errorCode;

    private final int httpStatus;

	public ServerErrorResponseDto(String message, ErrorCodeEnum errorCode, HttpStatus httpStatus) {

		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus.value();
	}

}
