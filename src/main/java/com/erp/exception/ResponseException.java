package com.erp.exception;

import java.io.Serializable;

public class ResponseException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public ResponseException(String msg) {
		super(msg);
	}

}
