package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "USERACTIVITYENTITY")
public class UserActivityEntity {

	@Id
    int id;
	String userName;
	String activityLog;
	String userRole;
	String activeDate;
	String activeTime;
	String activeHour;
    String activeTimeDescription;
    String userIpAddress;
}
