package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "HIPPARESPONSE")
public class HippaResponseEntity {

	@Id
	int id;
	ArrayList<HippaQuestionResponseEntity> hippaResponses;
	
}


