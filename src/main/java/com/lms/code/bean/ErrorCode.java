package com.lms.code.bean;

import org.springframework.stereotype.Component;

@Component
public class ErrorCode {
	private Integer code;
	private String message;

	public ErrorCode() {
	}

	public ErrorCode(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
