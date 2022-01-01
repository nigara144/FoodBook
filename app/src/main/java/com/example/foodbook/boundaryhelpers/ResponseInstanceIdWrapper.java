package com.example.foodbook.boundaryhelpers;

public class ResponseInstanceIdWrapper {
	private String responseId;
	
	public ResponseInstanceIdWrapper() {	
	}

	public String getResponseId() {
		System.out.println("---------This is getResponse"+responseId);
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

}
