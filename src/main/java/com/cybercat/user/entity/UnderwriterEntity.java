package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "UNDERWRITERENTITY")
public class UnderwriterEntity {

	@Id
	int id;
	String userType;
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	String insComp;
	UnderwriterAccessEntity underwriterAccess;	
	String createdDate;
	String createdTime;
	String modifiedDate;
	String modifiedTime;
}
