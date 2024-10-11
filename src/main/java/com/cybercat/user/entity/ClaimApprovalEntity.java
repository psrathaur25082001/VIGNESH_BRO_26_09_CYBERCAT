package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CLAIMAPPROVALENTITY")
public class ClaimApprovalEntity {

	@Id
	int id;
	String userType;
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	String insComp;
	ClaimApprovalAccessEntity claimApprovalAccess;	
	String createdDate;
	String createdTime;
	String modifiedDate;
	String modifiedTime;
}
