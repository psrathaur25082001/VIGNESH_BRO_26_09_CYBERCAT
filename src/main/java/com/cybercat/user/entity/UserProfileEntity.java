package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "USERPROFILE")
public class UserProfileEntity 
{
	@Id
	public int id;
	private String userName;
	private String email;
	private String password;
	private String mobile;
	String activityLog;
	String activeDate;
	String activeTime;
	String activeHour;
    String activeTimeDescription;
    String userIpAddress;
	private UserCategoryEntity category;
	private UserRoleEntity role;
	private String initiatedDate;
}
