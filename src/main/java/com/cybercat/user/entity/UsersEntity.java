package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "ALLUSERS")
public class UsersEntity {

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
	boolean premiumCyberAssessment;
	boolean advancedCyberAssessment;
	boolean basicCyberTechnical;
	boolean addedAdvanceTechnicalAssessment;
	String industry;
	String sector;
	String subIndustry;
	String division;
	String group;
	String optionText;
	String riskLevel;
	boolean sendIndustryAssessment;
	boolean hipaaAssessment;

	// Underwriter
	UnderwriterAccessEntity underwriterAccess;

	// Intermediary
	String level;

	// Agent
	AgentAccessEntity agentAccess;

	// Broker
	BrokerAccessEntity brokerAccess;

	// Brv
	BRVAccessEntity brvAccess;

	// Claim Approval
	boolean active;
	String createdDate;
	String createdTime;
	String modifiedDate;
	String modifiedTime;

}
