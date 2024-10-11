package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "IndustryMaster")
public class Industry_Master {

	@Id
    String id;
    String industryName;

}
