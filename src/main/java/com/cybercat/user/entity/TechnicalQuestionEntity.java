package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TECHNICALQUESTIONS")
public class TechnicalQuestionEntity {

	@Id
	int id;
	String question;
	String head;
	String technical;
	String type;
	String team;
	String section;
	String questionType;
	ArrayList<OptionEntity> options;
	boolean addedNotes;
}
