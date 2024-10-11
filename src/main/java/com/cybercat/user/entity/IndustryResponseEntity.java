package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "INDUSTRYRESPONSE")
public class IndustryResponseEntity {

	@Id
	int id;
	ArrayList<IndustryQuestionResponseEntity> indResponses;
	
}


