package com.cybercat.user.entity;

import java.util.ArrayList;

import lombok.Data;

@Data
public class StrategicQuestionResponseEntity {

	int index;
	int id;
	String question;
	String head;
	String strategic;
	String type;
	String team;
	String section;
	String questionType;
    ArrayList<OptionEntity> options;
	String answer;
	String checkBoxAnswer1;
	String checkBoxAnswer2;
	String checkBoxAnswer3;
	String checkBoxAnswer4;
	String checkBoxAnswer5;
	boolean marked;
	int answerOption;
	int score;
	boolean addedNotes;
	
}
