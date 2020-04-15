package com.electronic.entity;

public class ELECTRONIC_NEWS {
	private int NEWS_ID;
	private String NEWS_INTRO;
	private String NEWS_BULLETIN;
	private String NEWS_TITLE;
	private String NEWS_CONTENT;
	private String NEWS_INFO;
	private String NEWS_TIME;
	public ELECTRONIC_NEWS(int nEWS_ID, String nEWS_INTRO, String nEWS_BULLETIN, String nEWS_TITLE, String nEWS_CONTENT,
			String nEWS_INFO, String nEWS_TIME) {
		super();
		NEWS_ID = nEWS_ID;
		NEWS_INTRO = nEWS_INTRO;
		NEWS_BULLETIN = nEWS_BULLETIN;
		NEWS_TITLE = nEWS_TITLE;
		NEWS_CONTENT = nEWS_CONTENT;
		NEWS_INFO = nEWS_INFO;
		NEWS_TIME = nEWS_TIME;
	}
	public int getNEWS_ID() {
		return NEWS_ID;
	}
	public void setNEWS_ID(int nEWS_ID) {
		NEWS_ID = nEWS_ID;
	}
	public String getNEWS_INTRO() {
		return NEWS_INTRO;
	}
	public void setNEWS_INTRO(String nEWS_INTRO) {
		NEWS_INTRO = nEWS_INTRO;
	}
	public String getNEWS_BULLETIN() {
		return NEWS_BULLETIN;
	}
	public void setNEWS_BULLETIN(String nEWS_BULLETIN) {
		NEWS_BULLETIN = nEWS_BULLETIN;
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
