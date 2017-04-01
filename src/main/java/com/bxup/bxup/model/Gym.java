package com.bxup.bxup.model;

import org.springframework.web.multipart.MultipartFile;

public class Gym {
	
	private int id;
	
	private String avatar;
	
	private String name;
	
	private Long create_time;
	
	private Integer approved;
	
	private Integer delete_status;
	
	private String profile;
	
	private String address;
	
	private String tel;
	
	private Integer user_id ;
	
	private String province;
	
	private String city;
	
	private String tag;

	private Long hot;
	
	private String approvedfg;
	
	private Integer shelves;
		
	private MultipartFile gympicture1;
	
	private MultipartFile gympicture2;
	
	private MultipartFile gympicture3;
	
	private MultipartFile gympicture4;
	
	private MultipartFile gympicture5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}

	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public Integer getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(Integer delete_status) {
		this.delete_status = delete_status;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getHot() {
		return hot;
	}

	public void setHot(Long hot) {
		this.hot = hot;
	}

	public String getApprovedfg() {
		return approvedfg;
	}

	public void setApprovedfg(String approvedfg) {
		this.approvedfg = approvedfg;
	}
	
	public Integer getShelves() {
		return shelves;
	}

	public void setShelves(Integer shelves) {
		this.shelves = shelves;
	}

	public MultipartFile getGympicture1() {
		return gympicture1;
	}

	public void setGympicture1(MultipartFile gympicture1) {
		this.gympicture1 = gympicture1;
	}

	public MultipartFile getGympicture2() {
		return gympicture2;
	}

	public void setGympicture2(MultipartFile gympicture2) {
		this.gympicture2 = gympicture2;
	}

	public MultipartFile getGympicture3() {
		return gympicture3;
	}

	public void setGympicture3(MultipartFile gympicture3) {
		this.gympicture3 = gympicture3;
	}

	public MultipartFile getGympicture4() {
		return gympicture4;
	}

	public void setGympicture4(MultipartFile gympicture4) {
		this.gympicture4 = gympicture4;
	}

	public MultipartFile getGympicture5() {
		return gympicture5;
	}

	public void setGympicture5(MultipartFile gympicture5) {
		this.gympicture5 = gympicture5;
	}
}
