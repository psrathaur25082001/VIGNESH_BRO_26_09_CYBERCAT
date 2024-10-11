package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "ENTITY")
public class EntityList {

	@Id
    int id;
	String companyName;
	String address;
	String companyLogo;
	String contactNo;
	String contactNo1;
	String contactNo2;
	String linkExpiryDate;
	String adminCostPercentage;
	String acquisitionCostPercentage;
	String marginPercentage;
	String minimum;
	String maximum;
	String obligatoryToGic;
	String netRentation;
	String qst;
	String cedentCommission;
	String durationOfSubscription;
	String noOfAgents;
	String paymentMode;
	String noOfTokens;
	String initiatedDate;
	String Localtime;
	
}
