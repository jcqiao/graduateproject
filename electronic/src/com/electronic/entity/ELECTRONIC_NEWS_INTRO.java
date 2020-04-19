package com.electronic.entity;

public class ELECTRONIC_NEWS_INTRO {
	private int NEWS_ID;
	private String NEWS_INTRO;
	private String NEWS_TIME;
	public ELECTRONIC_NEWS_INTRO(int nEWS_ID, String nEWS_INTRO, String nEWS_TIME) {
		super();
		NEWS_ID = nEWS_ID;
		NEWS_INTRO = nEWS_INTRO;
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
	public String getNEWS_TIME() {
		return NEWS_TIME;
	}
	public void setNEWS_TIME(String nEWS_TIME) {
		NEWS_TIME = nEWS_TIME;
	}
	
}
