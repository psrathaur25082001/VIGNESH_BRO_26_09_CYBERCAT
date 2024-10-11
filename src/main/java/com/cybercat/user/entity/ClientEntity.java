package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CLIENTENTITY")
public class ClientEntity {

	@Id
	int id;
	String userType;
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	String clientComp;
	String designation;
	String insComp;
	String linkExpiryDate;
	String clientQuestionnaireType;
//	boolean premiumCyberAssessment;
//	boolean advancedCyberAssessment;
//	boolean basicCyberTechnical;
//	boolean addedAdvanceTechnicalAssessment;
	String duration;
	String industry;
	String sector;
	String subIndustry;
	String division;
	String group;
	String optionText;
	String riskLevel;
//	boolean sendIndustryAssessment;
	boolean hipaaAssessment;
	String createdDate;
	String createdTime;
	String modifiedDate;
	String modifiedTime;
}
