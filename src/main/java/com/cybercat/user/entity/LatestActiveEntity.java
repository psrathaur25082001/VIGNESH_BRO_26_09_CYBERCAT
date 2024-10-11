package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "LATESTACTIVEENTITY")
public class LatestActiveEntity {

	@Id
    int id;
	String clientName;
	String questype;
	String percentageOfCompletion;
	String industry;
	String initiatedDate;	
}
