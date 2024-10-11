package com.cybercat.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybercat.user.entity.LatestActiveEntity;
//import com.cybercat.user.entity.UserActivityEntity;
import com.cybercat.user.service.LatestActiveService;

@RestController
@RequestMapping("/latest/active")
public class LatestActiveController {

	@Autowired
	LatestActiveService latestActiveService;
	
	@GetMapping("/getLatestActive")
	public List<LatestActiveEntity> getLatestActive() {
		return latestActiveService.getLatestActive();
	}
	
	@PostMapping("/createLatestActive")
	public LatestActiveEntity createLatestActive(@RequestBody LatestActiveEntity latest) {
		return latestActiveService.createLatestActive(latest);
	}
	
}
