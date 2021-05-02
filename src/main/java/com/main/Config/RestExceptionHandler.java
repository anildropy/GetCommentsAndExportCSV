package com.main.Config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.main.Model.ErrorMessage;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ErrorMessage errorMessage;

	@ExceptionHandler(IOException.class)
	protected ResponseEntity<Object> handleIOException(IOException e) {
		errorMessage.setErrorCode(ErrorMessage.IOExceptionCODE);
		errorMessage.setErrorMessage(ErrorMessage.IOExceptionMessage);
		return new ResponseEntity<Object>(errorMessage, errorMessage.getErrorCode());
	}
}
