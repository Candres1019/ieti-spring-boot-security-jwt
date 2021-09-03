package org.ada.school.config;

import org.ada.school.error.InternalServerErrorException;
import org.ada.school.exception.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestControllerAdvice
class RestControllerErrorHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	private ResponseEntity<String> handleHTTPMessageNotReadable(HttpMessageNotReadableException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getCause().getMessage());
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	private ResponseEntity<String> handleMissingServletRequestPart(MissingServletRequestPartException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getCause().getMessage());
	}

	@ExceptionHandler(InternalServerErrorException.class)
	private ResponseEntity<ServerErrorResponseDto> handleRuntimeException(InternalServerErrorException exception) {

		return ResponseEntity.status(exception.getHttpStatus()).body(exception.getServerErrorResponseDto());
	}
}
