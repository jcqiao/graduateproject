package com.electronic.entity;

public class ELECTRONIC_NEWS_INFO {
	private int NEWS_ID;
	private String NEWS_INFO;
	private String NEWS_TIME;
	public ELECTRONIC_NEWS_INFO(int nEWS_ID, String nEWS_INFO, String nEWS_TIME) {
		super();
		NEWS_ID = nEWS_ID;
		NEWS_INFO = nEWS_INFO;
		NEWS_TIME = nEWS_TIME;
	}
	public int getNEWS_ID() {
		return NEWS_ID;
	}
	public void setNEWS_ID(int nEWS_ID) {
		NEWS_ID = nEWS_ID;
	}
	public String getNEWS_INFO() {
		return NEWS_INFO;
	}
	public void setNEWS_INFO(String nEWS_INFO) {
		NEWS_INFO = nEWS_INFO;
	}
	public String getNEWS_TIME() {
		return NEWS_TIME;
	}
	public void setNEWS_TIME(String nEWS_TIME) {
		NEWS_TIME = nEWS_TIME;
	}
	
}
