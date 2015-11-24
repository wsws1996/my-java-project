package com.wang.domain;

import java.util.Date;

public class News {
	/*
	 * @author 王爽
	 * @return 新闻id
	 */
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
//	public String getNewsContent() {
//		return newsContent;
//	}
//	public void setNewsContent(String newsContent) {
//		this.newsContent = newsContent;
//	}
	private int newsid;
	private String newsTitle;
	private Date newsDate;
	private String newsContent;
}
