package com.bxup.bxup.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Subscribe {

	private Integer id;

	private String title;

	private String tab;

	private String url;

	private String summary;

	private String img;

	private String imgUrl;
	
	private MultipartFile imgfile;
	
	private String feedImg;
	
	private String feedImgUrl;

	private Integer deleteStatus;

	private Integer subscribe_type;

	private Date publish_time;

	private Integer shelves;

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer status) {
		this.deleteStatus = status;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public MultipartFile getImgfile() {
		return imgfile;
	}

	public void setImgfile(MultipartFile imgfile) {
		this.imgfile = imgfile;
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
