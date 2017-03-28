package com.bxup.bxup.model;

import java.util.List;

public class User {

	private String sex;
	
	private Long user_Id;

	private String platform_id;// 第三方平台ID

	private String mobile;// 手机号

	private String avatar;// 头像

	private String intro;// 简介

	private String nickname;// 昵称

	private Integer gender;// 性别 1男 2女

	private String address;// 地址

	private Float height;// 身高

	private Float weight;// 体重

	private Integer age;// 年龄

	private Float rate_fat;// 脂肪率

	private String goal;// 健身目标

	private Long create_time;
	
	private Long last_login_time;
	
	private String last_login_ip;
	
	private String device_type;

	private List<Coach> coach;
	
	private List<Gym> gym;
	

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public String getPlatform_id() {
		return platform_id;
	}

	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getRate_fat() {
		return rate_fat;
	}

	public void setRate_fat(Float rate_fat) {
		this.rate_fat = rate_fat;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}

	public Long getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Long last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Coach> getCoach() {
		return coach;
	}

	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}

	public List<Gym> getGym() {
		return gym;
	}

	public void setGym(List<Gym> gym) {
		this.gym = gym;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



}
