package com.bxup.bxup.model;

import java.util.Date;

public class Subscribe {

	private Integer id;

	private String title;

	private String tab;

	private String url;

	private String summary;

	private String img;

	private String feedImg;
	
	private String feedImgUrl;

	private Integer status;

	private Integer subscribe_type;

	private Date publish_time;

	private Integer shelves;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSubscribe_type() {
		return subscribe_type;
	}

	public void setSubscribe_type(Integer subscribe_type) {
		this.subscribe_type = subscribe_type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getFeedImg() {
		return feedImg;
	}

	public void setFeedImg(String feedImg) {
		this.feedImg = feedImg;
	}

	public String getFeedImgUrl() {
		return feedImgUrl;
	}

	public void setFeedImgUrl(String feedImgUrl) {
		this.feedImgUrl = feedImgUrl;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public Integer getShelves() {
		return shelves;
	}

	public void setShelves(Integer shelves) {
		this.shelves = shelves;
	}

}
