package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "STRATEGICQUESTIONS")
@Data
public class StrategicQuestionEntity {
	@Id
	int id;
	String question;
	String head;
	String strategic;
	String type;
	String team;
	String section;
	String questionType;
	ArrayList<OptionEntity> options;
	boolean addedNotes;
}