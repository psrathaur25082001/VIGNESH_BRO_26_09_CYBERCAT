package com.cybercat.user.entity;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "INDUSTRYQUESTIONS")
public class IndustryQuestionEntity {

	@Id
	int id;
	String question;
	String industry;
	String industryType;
	String questionType;
	String head;
	String type;
	String team;
	String section;
    ArrayList<OptionEntity> options;
	boolean addedNotes;
}

