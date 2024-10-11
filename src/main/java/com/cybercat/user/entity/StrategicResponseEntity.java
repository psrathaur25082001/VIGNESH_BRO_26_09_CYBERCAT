package com.cybercat.user.entity;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "STRATEGICRESPONSE")
public class StrategicResponseEntity {

	@Id
	int id;
	ArrayList<StrategicQuestionResponseEntity> strResponses;

}