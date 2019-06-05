package com.lms.code.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto {
	private String success;
	private Object payload;
	private Object error;

	public ResponseDto() {
	}

	public ResponseDto(String success, Object payload, Object error) {
		super();
		this.success = success;
		this.payload = payload;
		this.error = error;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}
