package com.electronic.entity;

public class ELECTRONIC_NEWS_BULLETIN {
	private int NEWS_ID;
	private String NEWS_BULLETIN;
	private String NEWS_TIME;
	public ELECTRONIC_NEWS_BULLETIN(int nEWS_ID, String nEWS_BULLETIN, String nEWS_TIME) {
		super();
		NEWS_ID = nEWS_ID;
		NEWS_BULLETIN = nEWS_BULLETIN;
		NEWS_TIME = nEWS_TIME;
	}
	public int getNEWS_ID() {
		return NEWS_ID;
	}
	public void setNEWS_ID(int nEWS_ID) {
		NEWS_ID = nEWS_ID;
	}
	public String getNEWS_BULLETIN() {
		return NEWS_BULLETIN;
	}
	public void setNEWS_BULLETIN(String nEWS_BULLETIN) {
		NEWS_BULLETIN = nEWS_BULLETIN;
	}
	public String getNEWS_TIME() {
		return NEWS_TIME;
	}
	public void setNEWS_TIME(String nEWS_TIME) {
		NEWS_TIME = nEWS_TIME;
	}
	
}
