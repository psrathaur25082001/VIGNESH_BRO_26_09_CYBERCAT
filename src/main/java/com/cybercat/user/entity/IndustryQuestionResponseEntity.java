package com.cybercat.user.entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class IndustryQuestionResponseEntity {
	
	int index;
	int id;
	String industry;
	String question;
	String industryType;
	String questionType;
	String head;
	String type;
	String team;
	String section;;
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
