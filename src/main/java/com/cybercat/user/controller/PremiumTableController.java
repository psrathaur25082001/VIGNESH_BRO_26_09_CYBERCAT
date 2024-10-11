package com.cybercat.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.PremiumTableEntity;
import com.cybercat.user.entity.Response;
import com.cybercat.user.service.PremiumTableService;

@RestController
@RequestMapping("/premium")
@CrossOrigin
public class PremiumTableController {

	@Autowired
	PremiumTableService premiumTableService;

	@GetMapping("/getPremiumAllData")
	public List<PremiumTableEntity> Premiumdata() {
		return premiumTableService.Premiumdata();
	}
	
	@GetMapping("/getPremiumById")
	public Optional<PremiumTableEntity> PremiumdataId(@RequestParam int id) {
		return premiumTableService.PremiumdataId(id);
	}
	
	@PostMapping("/addPremiumData")
	public Response addPremiumTabledata(@RequestBody PremiumTableEntity AddPremiumData) {
		PremiumTableEntity premiumdata = premiumTableService.addPremiumTabledata(AddPremiumData);
		Response res = new Response();
		res.setMessage("Attack Data Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(premiumdata);
		res.setStatus(true);
		return res;
	}
	
}
