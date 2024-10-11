package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CYBER-PRO-MASTER")
public class CyberProEntity {

	@Id
    int id;
    String industryName;
    String sector;
    String subIndustryName;   
}
