package com.shreedhar.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="email_id", nullable=false)
	String emailId;
	
	@Column(name="Password", nullable=false)
	String password;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="Phone")
	Integer phone;
	
	@Column(name="user_type")
	String userType;

	public User(){
		
	}
	
	public User(String emailId, String password, String userName,
			Integer phone, String userType) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.userName = userName;
		this.phone = phone;
		this.userType = userType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password
				+ ", userName=" + userName + ", phone=" + phone + ", userType="
				+ userType + "]";
	}
}
