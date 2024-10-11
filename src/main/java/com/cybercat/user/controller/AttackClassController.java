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
import com.cybercat.user.entity.AttackLibraryEntity;
import com.cybercat.user.entity.Response;
import com.cybercat.user.service.AttackClassService;

@RestController
@RequestMapping("/attack/class")
@CrossOrigin
public class AttackClassController {
	
	@Autowired
	AttackClassService  attackClassService;

	@GetMapping("/getAttackdata")
	public List<AttackClassEntity> getAttackdata(){
		return attackClassService.getAttackdata();
		
	}
	
	@GetMapping("/getAttackClassByid")
	public Optional<AttackClassEntity> attackClassid(@RequestParam int id) {
		return attackClassService.attackClassid(id);
	}
	
	@PostMapping("/addAttackClassData")
	public Response addAttackClassdata(@RequestBody AttackClassEntity attackClassques) {
		AttackClassEntity attackClass = attackClassService.addAttackClassdata(attackClassques);
		Response res = new Response();
		res.setMessage("Attack Data Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(attackClass);
		res.setStatus(true);
		return res;
	}
}
