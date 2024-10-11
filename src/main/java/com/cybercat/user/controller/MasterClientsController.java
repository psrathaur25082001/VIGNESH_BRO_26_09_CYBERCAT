package com.cybercat.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybercat.user.entity.CyberProEntity;
import com.cybercat.user.entity.CyberSMEEntity;
import com.cybercat.user.entity.InsuranceEntity;
import com.cybercat.user.service.MasterClientsService;

@RestController
@RequestMapping("/clients/master")
@CrossOrigin
public class MasterClientsController {

	@Autowired
	MasterClientsService masterClients;

	@GetMapping("/getInsurance")
	public List<InsuranceEntity> getInsurance() {
		return masterClients.getInsurance();
	}
	
	// SME
	@GetMapping("/getSMEIndustry")
	public List<CyberSMEEntity> getSMEIndustry() {
		return masterClients.getSMEIndustry();
	}

	@GetMapping("/getSMEDivisions")
	public List<CyberSMEEntity> getSMEDivisions(@RequestParam String divisions) {
		return masterClients.getSMEDivisions(divisions);
	}

	@GetMapping("/getSMEGroups")
	public List<CyberSMEEntity> getSMEGroups(@RequestParam String groups) {
		return masterClients.getSMEGroups(groups);
	}

	// SME
	@GetMapping("/getProIndustry")
	public List<CyberProEntity> getProIndustry() {
		return masterClients.getProIndustry();
	}

	@GetMapping("/getProSector")
	public List<CyberProEntity> getProSector(@RequestParam String sector) {
		return masterClients.getProSector(sector);
	}
	
	@GetMapping("/getProSubIndustry")
	public List<CyberProEntity> getProSubIndustry(@RequestParam String subIndustry) {
		return masterClients.getProSubIndustry(subIndustry);
	}
	
}
