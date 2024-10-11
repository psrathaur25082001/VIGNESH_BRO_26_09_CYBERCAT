package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "INSURANCECOMPANY")
public class InsuranceEntity {
 
	@Id
    int id;
	String insuranceType;
}
