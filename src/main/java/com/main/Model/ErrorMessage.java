package com.main.Model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {

	public static final HttpStatus IOExceptionCODE = HttpStatus.FORBIDDEN;
	public static final String IOExceptionMessage = "IOExceptionError occurred!";

	private HttpStatus errorCode;
	private String errorMessage;

	public ErrorMessage() {
	}

	public ErrorMessage(HttpStatus errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static HttpStatus getIoexceptioncode() {
		return IOExceptionCODE;
	}

	public static String getIoexceptionmessage() {
		return IOExceptionMessage;
	}

}
