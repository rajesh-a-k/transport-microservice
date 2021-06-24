package com.tm.transport.response;

public class SuccessResponse {
	
	private String successCode;
	private String successMessage;
	
	
	/**
	 * @param successCode
	 * @param successMessage
	 */
	public SuccessResponse(String successCode, String successMessage) {
		super();
		this.successCode = successCode;
		this.successMessage = successMessage;
	}
	/**
	 * @return the successCode
	 */
	public String getSuccessCode() {
		return successCode;
	}
	/**
	 * @param successCode the successCode to set
	 */
	public void setSuccessCode(String successCode) {
		this.successCode = successCode;
	}
	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}
	/**
	 * @param successMessage the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
	
}
