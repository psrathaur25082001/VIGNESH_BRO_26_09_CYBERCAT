package com.cybercat.user.entity;

import lombok.Data;

@Data
public class HippaQuestionResponseEntity {

	int index;
	int id;
	String question;
	String type;
	String head;
	String answer;
	boolean marked;
	int answerOption;
	int score;
	boolean addedNotes;	
}

