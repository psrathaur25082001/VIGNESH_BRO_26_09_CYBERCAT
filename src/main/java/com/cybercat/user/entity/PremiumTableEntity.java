package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="Premium_table")
@Data
public class PremiumTableEntity {

	@Id
	int id;
	String policy_no;
	String insurance_reference;
	String date_of_issue;
	String client_name;
	String sum_insured;
	String SI_retained_risk;
	String SI_OBL_GIC;
	String SI_reinsured_risk;
	String gross_premium;
	String reinsurance_premium;
	String OBLG_GIC_PREM;
	String cendant_commission;
	String net_premium_status;
}
