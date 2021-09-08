package org.ada.school.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ada.school.exception.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class InternalServerErrorException extends RuntimeException {

	private final ServerErrorResponseDto serverErrorResponseDto;

	private final HttpStatus httpStatus;

}
