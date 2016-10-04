package com.idividends.data.dto;

public enum TaskResult {
	SUCCESS("Success", "S000"),
	ERROR_NO_RESULT("No result", "E000"),
	ERROR_REMOTE_SERVER_NOT_AVAILABLE("Remote server is not available","E001"),
	
	
	;

	private String message;
	private String code;

	/**
	 * @param message
	 * @param code
	 */
	private TaskResult(String message, String code) {
		this.message = message;
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
