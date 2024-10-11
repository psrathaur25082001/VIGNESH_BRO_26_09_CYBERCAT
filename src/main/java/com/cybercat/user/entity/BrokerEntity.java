package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "BROKERENTITY")
public class BrokerEntity {

	@Id
	int id;
	String userType;
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	String insComp;
	BrokerAccessEntity brokerAccess;	
	String createdDate;
	String createdTime;
	String modifiedDate;
	String modifiedTime;
}
