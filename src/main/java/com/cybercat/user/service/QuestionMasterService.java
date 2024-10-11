package com.cybercat.user.service;

import java.util.List;
import com.cybercat.user.entity.ControlsCountEntity;
import com.cybercat.user.entity.HippaQuestionEntity;
import com.cybercat.user.entity.HippaResponseEntity;
import com.cybercat.user.entity.IndustryQuesCountEntity;
import com.cybercat.user.entity.IndustryQuestionEntity;
import com.cybercat.user.entity.IndustryResponseEntity;
//import com.cybercat.user.entity.RecordsOfAustralia;
import com.cybercat.user.entity.StrQuesCountEntity;
import com.cybercat.user.entity.StrategicQuestionEntity;
import com.cybercat.user.entity.TechQuesCountEntity;
import com.cybercat.user.entity.TechnicalQuestionEntity;
import com.cybercat.user.entity.StrategicResponseEntity;
//import com.cybercat.user.entity.TPCEntity;
import com.cybercat.user.entity.TechnicalResponseEntity;

public interface QuestionMasterService {

	TechQuesCountEntity getTechQuesCountTeam(int clientID);

	boolean resend(int clientID) throws Exception;

	List<ControlsCountEntity> techControlHead(String techHead, int clientID);

	List<ControlsCountEntity> techControlType(String techType, int clientID);

	List<ControlsCountEntity> techControlTeam(String techTeam, int clientID);

	TechnicalResponseEntity techControlsQuestion(String techControls, int clientID);

	TechnicalResponseEntity techSaveRes(int index, String answer, int answerOption, int clientID, int score);

	boolean techMarkQues(int index, int clientID, boolean value);

	// strategic
	List<ControlsCountEntity> strControlHead(String strHead, int clientID);

	List<ControlsCountEntity> strControlType(String strType, int clientID);

	List<ControlsCountEntity> strControlTeam(String strTeam, int clientID);

	StrategicResponseEntity strControlsQuestion(String strControls, int clientID);

	StrategicResponseEntity strSaveRes(int index, String answer, int answerOption, int clientID, int score);

	boolean strMarkQues(int index, int clientID, boolean value);

	// industry
	List<ControlsCountEntity> indControlHead(String indHead, int clientID);

	List<ControlsCountEntity> indControlType(String indType, int clientID);

	List<ControlsCountEntity> indControlTeam(String indTeam, int clientID);

	IndustryResponseEntity indControlsQuestion(String indControls, int clientID);

	IndustryResponseEntity indSaveRes(int index, String answer, int answerOption, int clientID, int score);

	boolean indMarkQues(int index, int clientID, boolean value);

	List<ControlsCountEntity> hippaControlHead(String hippaHead, int clientID);

	HippaResponseEntity hippaControlsQuestion(String hippaControls, int clientID);

	HippaResponseEntity hippaSaveRes(int index, String answer, int answerOption, int clientID, int score);

	boolean hippaMarkQues(int index, int clientID, boolean value);

	StrQuesCountEntity getStrQuesCountTeam(int clientID);

	TechnicalResponseEntity allTechnicalQuestions(int clientID);

	StrategicResponseEntity allStrategicQuestions(int clientID);

	IndustryResponseEntity allIndustryQuestions(int clientID);

	HippaResponseEntity allHippaQuestions(int clientID);

	TechnicalResponseEntity techTextRes(int index, String answer, int clientID);

	TechnicalResponseEntity techCheckBoxRes(int index, String answer, String answer1, String answer2, String answer3,
			String answer4, String answer5, int answerOption, int clientID, int score);

	StrategicResponseEntity strCheckBoxRes(int index, String answer, String answer1, String answer2, String answer3,
			String answer4, String answer5, int answerOption, int clientID, int score);

	StrategicResponseEntity strTextRes(int index, String answer, int clientID);

	IndustryQuesCountEntity getIndustryQuesCountTeam(int clientID);

	IndustryResponseEntity indCheckBoxRes(int index, String answer, String answer1, String answer2, String answer3,
			String answer4, String answer5, int answerOption, int clientID, int score);

	IndustryResponseEntity indTextRes(int index, String answer, int clientID);

	StrategicQuestionEntity addStrategicQuestions(StrategicQuestionEntity ques) ;

	List<StrategicQuestionEntity> strategic();

	List<TechnicalQuestionEntity> technical();

	List<IndustryQuestionEntity> industry();

	List<HippaQuestionEntity> hippa();

	TechnicalQuestionEntity addTechnicalQuestions(TechnicalQuestionEntity ques) throws Exception;

	IndustryQuestionEntity addIndustryQuestions(IndustryQuestionEntity ques) throws Exception;

	HippaQuestionEntity addHippaQuestions(HippaQuestionEntity ques) throws Exception;

	List<String> getHeadAndScores();

	StrategicQuestionEntity editStrategicQuestions(StrategicQuestionEntity str, int id);

	TechnicalQuestionEntity editTechnicalQuestions(TechnicalQuestionEntity tech, int id);

	IndustryQuestionEntity editIndustryQuestions(IndustryQuestionEntity ind, int id);

	HippaQuestionEntity editHippaQuestions(HippaQuestionEntity hippa, int id);

	TechnicalQuestionEntity fetchTechnicalDraft(int clientID);

	IndustryQuestionEntity fetchIndustryDraft(int clientID);

	StrategicQuestionEntity fetchStrategicDraft(int clientID);

}
