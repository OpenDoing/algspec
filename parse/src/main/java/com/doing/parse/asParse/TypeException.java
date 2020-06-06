package com.doing.parse.asParse;

public class TypeException extends ParseException{
	
	private TypeError errorType;
	private String errorMessage;
	private Token t;
	
	public TypeException(TypeError errorType, String errorMessage, Token t) {
		super();
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.t = t;
	}
	
	public TypeException(TypeError errorType, String errorMessage) {
		super();
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}
	
	public String prettyMessage() {
		String errorMsg = "Type Error: " + errorType + "\n";
		errorMsg += "line: " + t.beginLine + "  column: " + t.beginColumn + "  token: " + t.image + "\n";
		errorMsg += "errorMessage: " + errorMessage;
		return errorMsg;
	}
	public String returnMessage() {
		String returnMsg =  "line: " + t.beginLine + "  column: " + t.beginColumn + "  token: " + t.image + "\n";
		returnMsg += "errorMessage: " + errorMessage;
		return returnMsg;
	}
	
	public String simpleMessage() {
		String errorMsg = "Type Error: " + errorType + "\n";	
		errorMsg += "errorMessage: " + errorMessage;
		return errorMsg;
	}
}
