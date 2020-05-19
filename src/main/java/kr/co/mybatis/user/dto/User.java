package kr.co.mybatis.user.dto;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String id;
	private String password;
	private String email;
	private String emailId;
	private String emailAddress;
	private String nickname;
	private String gender;
	private int auth;
	private String reg_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", emailId=" + emailId
				+ ", emailAddress=" + emailAddress + ", nickname=" + nickname + ", gender=" + gender + ", auth=" + auth
				+ ", reg_date=" + reg_date + "]";
	}
	
	
	}
