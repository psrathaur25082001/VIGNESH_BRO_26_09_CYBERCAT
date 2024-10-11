package com.cybercat.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cybercat.user.entity.TechnicalResponseEntity;
import com.cybercat.user.entity.ControlsCountEntity;
import com.cybercat.user.entity.HippaQuestionEntity;
import com.cybercat.user.entity.HippaResponseEntity;
import com.cybercat.user.entity.IndustryQuesCountEntity;
import com.cybercat.user.entity.IndustryQuestionEntity;
import com.cybercat.user.entity.IndustryResponseEntity;
//import com.cybercat.user.entity.RecordsOfAustralia;
import com.cybercat.user.entity.Response;
import com.cybercat.user.entity.StrQuesCountEntity;
import com.cybercat.user.entity.StrategicQuestionEntity;
import com.cybercat.user.entity.StrategicResponseEntity;
//import com.cybercat.user.entity.TPCEntity;
import com.cybercat.user.entity.TechQuesCountEntity;
import com.cybercat.user.entity.TechnicalQuestionEntity;
import com.cybercat.user.service.QuestionMasterService;

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionMasterController {

	@Autowired
	QuestionMasterService questionMasterService;

	 @GetMapping("/head-scores")
	    public List<String> getHeadAndScores() {
	        return questionMasterService.getHeadAndScores();
	    }
	 
	@GetMapping("/getStrQuesCountTeam")
	public StrQuesCountEntity getStrQuesCountTeam(@RequestParam int clientID) {
		return questionMasterService.getStrQuesCountTeam(clientID);
	}
	
	@GetMapping("/getTechQuesCountTeam")
	public TechQuesCountEntity getTechQuesCountTeam(@RequestParam int clientID) {
		return questionMasterService.getTechQuesCountTeam(clientID);
	}

	@GetMapping("/getIndustryQuesCountTeam")
	public IndustryQuesCountEntity getIndustryQuesCountTeam(@RequestParam int clientID) {
		return questionMasterService.getIndustryQuesCountTeam(clientID);
	}
	
	@GetMapping("/resend")
	public boolean resend(@RequestParam int clientID) throws Exception {
		return questionMasterService.resend(clientID);
	}

	@GetMapping("/techControlHead")
	public List<ControlsCountEntity> techControlHead(@RequestParam String techHead, int clientID) {
		return questionMasterService.techControlHead(techHead, clientID);
	}

	@GetMapping("/techControlType")
	public List<ControlsCountEntity> techControlType(@RequestParam String techType, int clientID) {
		return questionMasterService.techControlType(techType, clientID);
	}

	@GetMapping("/techControlTeam")
	public List<ControlsCountEntity> techControlTeam(@RequestParam String techTeam, int clientID) {
		return questionMasterService.techControlTeam(techTeam, clientID);
	}

	@GetMapping("/techControlsQuestion")
	public TechnicalResponseEntity techControlsQuestion(@RequestParam String techControls, int clientID) {
		return questionMasterService.techControlsQuestion(techControls, clientID);
	}

	@GetMapping("/allTechnicalQuestions")
	public TechnicalResponseEntity allTechnicalQuestions(@RequestParam int clientID) {
		return questionMasterService.allTechnicalQuestions(clientID);
	}
	
	@GetMapping("/techSaveRes")
	public TechnicalResponseEntity techSaveRes(@RequestParam int index, String answer, int answerOption, int clientID,
			int score) {
		return questionMasterService.techSaveRes(index, answer, answerOption, clientID, score);
	}

	@GetMapping("/techCheckBoxRes")
	public TechnicalResponseEntity techCheckBoxRes(@RequestParam int index, String answer,String answer1,String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID,
			int score) {
		return questionMasterService.techCheckBoxRes(index, answer, answer1, answer2, answer3, answer4, answer5, answerOption, clientID, score);
	}
	
	@GetMapping("/techTextRes")
	public TechnicalResponseEntity techTextRes(@RequestParam int index, String answer, int clientID) {
		return questionMasterService.techTextRes(index, answer, clientID);
	}
	
	@GetMapping("/techMarkQues")
	public boolean techMarkQues(@RequestParam int index, int clientID, boolean value) {
		return questionMasterService.techMarkQues(index, clientID, value);
	}

	// strategic
	@GetMapping("/strControlHead")
	public List<ControlsCountEntity> strControlHead(@RequestParam String strHead, int clientID) {
		return questionMasterService.strControlHead(strHead, clientID);
	}

	@GetMapping("/strControlType")
	public List<ControlsCountEntity> strControlType(@RequestParam String strType, int clientID) {
		return questionMasterService.strControlType(strType, clientID);
	}

	@GetMapping("/strControlTeam")
	public List<ControlsCountEntity> strControlTeam(@RequestParam String strTeam, int clientID) {
		return questionMasterService.strControlTeam(strTeam, clientID);
	}

	@GetMapping("/strControlsQuestion")
	public StrategicResponseEntity strControlsQuestion(@RequestParam String strControls, int clientID) {
		return questionMasterService.strControlsQuestion(strControls, clientID);
	}

	@GetMapping("/allStrategicQuestions")
	public StrategicResponseEntity allStrategicQuestions(@RequestParam int clientID) {
		return questionMasterService.allStrategicQuestions(clientID);
	}
	
	@GetMapping("/strSaveRes")
	public StrategicResponseEntity strSaveRes(@RequestParam int index, String answer, int answerOption, int clientID,
			int score) {
		return questionMasterService.strSaveRes(index, answer, answerOption, clientID, score);
	}

	@GetMapping("/strCheckBoxRes")
	public StrategicResponseEntity strCheckBoxRes(@RequestParam int index, String answer,String answer1,String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID,
			int score) {
		return questionMasterService.strCheckBoxRes(index, answer, answer1, answer2, answer3, answer4, answer5, answerOption, clientID, score);
	}
	
	@GetMapping("/strTextRes")
	public StrategicResponseEntity strTextRes(@RequestParam int index, String answer, int clientID) {
		return questionMasterService.strTextRes(index, answer, clientID);
	}
	
	@GetMapping("/strMarkQues")
	public boolean strMarkQues(@RequestParam int index, int clientID, boolean value) {
		return questionMasterService.strMarkQues(index, clientID, value);
	}

	// industry
	@GetMapping("/indControlHead")
	public List<ControlsCountEntity> indControlHead(@RequestParam String indHead, int clientID) {
		return questionMasterService.indControlHead(indHead, clientID);
	}

	@GetMapping("/indControlType")
	public List<ControlsCountEntity> indControlType(@RequestParam String indType, int clientID) {
		return questionMasterService.indControlType(indType, clientID);
	}

	@GetMapping("/indControlTeam")
	public List<ControlsCountEntity> indControlTeam(@RequestParam String indTeam, int clientID) {
		return questionMasterService.indControlTeam(indTeam, clientID);
	}

	@GetMapping("/indControlsQuestion")
	public IndustryResponseEntity indControlsQuestion(@RequestParam String indControls, int clientID) {
		return questionMasterService.indControlsQuestion(indControls, clientID);
	}

	@GetMapping("/allIndustryQuestions")
	public IndustryResponseEntity allIndustryQuestions(@RequestParam int clientID) {
		return questionMasterService.allIndustryQuestions(clientID);
	}
	
	@GetMapping("/indSaveRes")
	public IndustryResponseEntity indSaveRes(@RequestParam int index, String answer, int answerOption, int clientID,
			int score) {
		return questionMasterService.indSaveRes(index, answer, answerOption, clientID, score);
	}

	@GetMapping("/indCheckBoxRes")
	public IndustryResponseEntity indCheckBoxRes(@RequestParam int index, String answer,String answer1,String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID,
			int score) {
		return questionMasterService.indCheckBoxRes(index, answer, answer1, answer2, answer3, answer4, answer5, answerOption, clientID, score);
	}
	
	@GetMapping("/indTextRes")
	public IndustryResponseEntity indTextRes(@RequestParam int index, String answer, int clientID) {
		return questionMasterService.indTextRes(index, answer, clientID);
	}
	
	@GetMapping("/indMarkQues")
	public boolean indMarkQues(@RequestParam int index, int clientID, boolean value) {
		return questionMasterService.indMarkQues(index, clientID, value);
	}

	// hippa
	@GetMapping("/hippaControlHead")
	public List<ControlsCountEntity> hippaControlHead(@RequestParam String hippaHead, int clientID) {
		return questionMasterService.hippaControlHead(hippaHead, clientID);
	}	
	@GetMapping("/hippaControlsQuestion")
	public HippaResponseEntity hippaControlsQuestion(@RequestParam String hippaControls, int clientID) {
		return questionMasterService.hippaControlsQuestion(hippaControls, clientID);
	}
	@GetMapping("/allHippaQuestions")
	public HippaResponseEntity allHippaQuestions(@RequestParam int clientID) {
		return questionMasterService.allHippaQuestions(clientID);
	}
	
	@GetMapping("/hippaSaveRes")
	public HippaResponseEntity hippaSaveRes(@RequestParam int index, String answer, int answerOption, int clientID,
			int score) {
		return questionMasterService.hippaSaveRes(index, answer, answerOption, clientID, score);
	}

	@GetMapping("/hippaMarkQues")
	public boolean hippaMarkQues(@RequestParam int index, int clientID, boolean value) {
		return questionMasterService.hippaMarkQues(index, clientID, value);
	}

	@GetMapping("/strategic")
	public List<StrategicQuestionEntity> strategic() {
		return questionMasterService.strategic();
	}
	
	@GetMapping("/technical")
	public List<TechnicalQuestionEntity> technical() {
		return questionMasterService.technical();
	}
	
	@GetMapping("/industry")
	public List<IndustryQuestionEntity> industry() {
		return questionMasterService.industry();
	}
	
	@GetMapping("/hippa")
	public List<HippaQuestionEntity> hippa() {
		return questionMasterService.hippa();
	}
	
	@PostMapping("/addStrategicQuestions")
	public Response addStrategicQuestions(@RequestBody StrategicQuestionEntity ques) {
		StrategicQuestionEntity strategic = questionMasterService.addStrategicQuestions(ques);
		Response res = new Response();
		res.setMessage("Strategic Question Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(strategic);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/editStrategicQuestions")
	public Response editStrategicQuestions(@RequestBody StrategicQuestionEntity str,@RequestParam int id) throws Exception {
		StrategicQuestionEntity strategicQues = questionMasterService.editStrategicQuestions(str,id);
		Response res = new Response();
		res.setMessage("Strategic Question Edited Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(strategicQues);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/addTechnicalQuestions")
	public Response addTechnicalQuestions(@RequestBody TechnicalQuestionEntity ques) throws Exception {
		TechnicalQuestionEntity strategic = questionMasterService.addTechnicalQuestions(ques);
		Response res = new Response();
		res.setMessage("Technical Question Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(strategic);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/editTechnicalQuestions")
	public Response editTechnicalQuestions(@RequestBody TechnicalQuestionEntity tech,@RequestParam int id) throws Exception {
		TechnicalQuestionEntity technicalQues = questionMasterService.editTechnicalQuestions(tech,id);
		Response res = new Response();
		res.setMessage("Technical Question Edited Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(technicalQues);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/addIndustryQuestions")
	public Response addIndustryQuestions(@RequestBody IndustryQuestionEntity ques) throws Exception {
		IndustryQuestionEntity industry = questionMasterService.addIndustryQuestions(ques);
		Response res = new Response();
		res.setMessage("Industry Question Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(industry);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/editIndustryQuestions")
	public Response editIndustryQuestions(@RequestBody IndustryQuestionEntity ind, @RequestParam int id) throws Exception {
		IndustryQuestionEntity industryQues = questionMasterService.editIndustryQuestions(ind,id);
		Response res = new Response();
		res.setMessage("Industry Question Edited Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(industryQues);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/addHippaQuestions")
	public Response addHippaQuestions(@RequestBody HippaQuestionEntity ques) throws Exception {
		HippaQuestionEntity strategic = questionMasterService.addHippaQuestions(ques);
		Response res = new Response();
		res.setMessage("Hippa Question Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(strategic);
		res.setStatus(true);
		return res;		
	}
	
	@PostMapping("/editHippaQuestions")
	public Response editHippaQuestions(@RequestBody HippaQuestionEntity hippa, @RequestParam int id) throws Exception {
		HippaQuestionEntity industryQues = questionMasterService.editHippaQuestions(hippa,id);
		Response res = new Response();
		res.setMessage("Hippa Question Edited Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(industryQues);
		res.setStatus(true);
		return res;		
	}
	
	@GetMapping("/getStrategicDraft")
	public StrategicQuestionEntity getStrategicDraft(@RequestParam int clientID) {
		return questionMasterService.fetchStrategicDraft(clientID);
	}
	
	@GetMapping("/getTechnicalDraft")
	public TechnicalQuestionEntity getTechnicalDraft(@RequestParam int clientID) {
		return questionMasterService.fetchTechnicalDraft(clientID);
	}
	
	@GetMapping("/getIndustryDraft")
	public IndustryQuestionEntity getIndustryDraft(@RequestParam int clientID) {
		return questionMasterService.fetchIndustryDraft(clientID);
	}
	
}
