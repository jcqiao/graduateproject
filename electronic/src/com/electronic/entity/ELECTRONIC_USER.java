package com.electronic.entity;

public class ELECTRONIC_USER {
	private String USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	private String USER_SEX;
	private String USER_MOBILE;
	private int USER_STATUS;
	public ELECTRONIC_USER(String uSER_ID, String uSER_NAME, String uSER_PASSWORD, String uSER_SEX,  String uSER_MOBILE,  int uSER_STATUS) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_SEX = uSER_SEX;
		USER_MOBILE = uSER_MOBILE;
		USER_STATUS = uSER_STATUS;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_SEX() {
		return USER_SEX;
	}
	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}
	public String getUSER_MOBILE() {
		return USER_MOBILE;
	}
	public void setUSER_MOBILE(String uSER_MOBILE) {
		USER_MOBILE = uSER_MOBILE;
	}
	public int getUSER_STATUS() {
		return USER_STATUS;
	}
	public void setUSER_STATUS(int uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}
	
}
