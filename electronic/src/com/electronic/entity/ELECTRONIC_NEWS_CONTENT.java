package com.electronic.entity;

public class ELECTRONIC_NEWS_CONTENT {
	private int NEWS_ID;
	private String NEWS_TITLE;
	private String NEWS_CONTENT;
	private String NEWS_TIME;
	public ELECTRONIC_NEWS_CONTENT(int nEWS_ID, String nEWS_TITLE, String nEWS_CONTENT, String nEWS_TIME) {
		super();
		NEWS_ID = nEWS_ID;
		NEWS_TITLE = nEWS_TITLE;
		NEWS_CONTENT = nEWS_CONTENT;
		NEWS_TIME = nEWS_TIME;
	}
	public int getNEWS_ID() {
		return NEWS_ID;
	}
	public void setNEWS_ID(int nEWS_ID) {
		NEWS_ID = nEWS_ID;
	}
	public String getNEWS_TITLE() {
		return NEWS_TITLE;
	}
	public void setNEWS_TITLE(String nEWS_TITLE) {
		NEWS_TITLE = nEWS_TITLE;
	}
	public String getNEWS_CONTENT() {
		return NEWS_CONTENT;
	}
	public void setNEWS_CONTENT(String nEWS_CONTENT) {
		NEWS_CONTENT = nEWS_CONTENT;
	}
	public String getNEWS_TIME() {
		return NEWS_TIME;
	}
	public void setNEWS_TIME(String nEWS_TIME) {
		NEWS_TIME = nEWS_TIME;
	}

	
}
