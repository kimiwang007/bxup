package com.bxup.bxup.model;

import org.springframework.web.multipart.MultipartFile;

public class Coach {
	
	private int id;
	
	private String avatar;
	
	private int gym_id;
	
	private String name;	
	
	private long create_time;
	
	private int approved;
	
	private int delete_status; 
	
	private int gendar;
	
	private int age;  
	
	private String genius;  
	
	private String honor;  
	
	private String profile;
	
	private int user_id; 
	
	private String province;
	
	private String city;
	
	private String address;
	
	private String tag;
	
	private int hot;
	
	private String gym_name;
	
	private String sex;
	
	private String approvedfg;
	
	private String pictureurl;
	
	private MultipartFile photo;
	
	private Long photo1_id;
	
	private MultipartFile picture1;
	
	private String pictureName1;
	
	private Long photo2_id;
	
	private MultipartFile picture2;
	
	private String pictureName2;
	
	private Long photo3_id;
	
	private MultipartFile picture3;
	
	private String pictureName3;
	
	private Long photo4_id;
	
	private MultipartFile picture4;
	
	private String pictureName4;
	
	private Long photo5_id;
	
	private MultipartFile picture5;
	
	private String pictureName5;
	
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getApprovedfg() {
		return approvedfg;
	}
	public void setApprovedfg(String approvedfg) {
		this.approvedfg = approvedfg;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public String getGym_name() {
		return gym_name;
	}
	public void setGym_name(String gym_name) {
		this.gym_name = gym_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGym_id() {
		return gym_id;
	}
	public void setGym_id(int gym_id) {
		this.gym_id = gym_id;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getDelete_status() {
		return delete_status;
	}
	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}
	public int getGendar() {
		return gendar;
	}
	public void setGendar(int gendar) {
		this.gendar = gendar;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getGenius() {
		return genius;
	}
	public void setGenius(String genius) {
		this.genius = genius;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public MultipartFile getPicture1() {
		return picture1;
	}
	public void setPicture1(MultipartFile picture1) {
		this.picture1 = picture1;
	}
	public MultipartFile getPicture2() {
		return picture2;
	}
	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}
	public MultipartFile getPicture3() {
		return picture3;
	}
	public void setPicture3(MultipartFile picture3) {
		this.picture3 = picture3;
	}
	public MultipartFile getPicture4() {
		return picture4;
	}
	public void setPicture4(MultipartFile picture4) {
		this.picture4 = picture4;
	}
	public MultipartFile getPicture5() {
		return picture5;
	}
	public void setPicture5(MultipartFile picture5) {
		this.picture5 = picture5;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPictureName1() {
		return pictureName1;
	}
	public void setPictureName1(String pictureName1) {
		this.pictureName1 = pictureName1;
	}
	public String getPictureName2() {
		return pictureName2;
	}
	public void setPictureName2(String pictureName2) {
		this.pictureName2 = pictureName2;
	}
	public String getPictureName3() {
		return pictureName3;
	}
	public void setPictureName3(String pictureName3) {
		this.pictureName3 = pictureName3;
	}
	public String getPictureName4() {
		return pictureName4;
	}
	public void setPictureName4(String pictureName4) {
		this.pictureName4 = pictureName4;
	}
	public String getPictureName5() {
		return pictureName5;
	}
	public void setPictureName5(String pictureName5) {
		this.pictureName5 = pictureName5;
	}
	public Long getPhoto1_id() {
		return photo1_id;
	}
	public void setPhoto1_id(Long photo1_id) {
		this.photo1_id = photo1_id;
	}
	public Long getPhoto2_id() {
		return photo2_id;
	}
	public void setPhoto2_id(Long photo2_id) {
		this.photo2_id = photo2_id;
	}
	public Long getPhoto3_id() {
		return photo3_id;
	}
	public void setPhoto3_id(Long photo3_id) {
		this.photo3_id = photo3_id;
	}
	public Long getPhoto4_id() {
		return photo4_id;
	}
	public void setPhoto4_id(Long photo4_id) {
		this.photo4_id = photo4_id;
	}
	public Long getPhoto5_id() {
		return photo5_id;
	}
	public void setPhoto5_id(Long photo5_id) {
		this.photo5_id = photo5_id;
	}
	
}
