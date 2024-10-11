package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TECHNICALRESPONSE")
public class TechnicalResponseEntity {

	@Id
	int id;
	ArrayList<TechnicalQuestionResponseEntity> techResponses;
	
}

