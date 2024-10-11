package com.cybercat.user.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.UserProfileEntity;
import com.cybercat.user.service.UserProfileService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user/validation")
@CrossOrigin
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@PostMapping("/createUserProfile")
	public UserProfileEntity createUserProfile(@RequestBody UserProfileEntity profile) throws IOException {
		return userProfileService.createUserProfile(profile);
	}

	@GetMapping("/emailCheck")
	public boolean emailCheck(@RequestParam String email) {
		return userProfileService.emailCheck(email);
	}

	@GetMapping("/emailAndPassCheck")
	public boolean emailAndPassCheck(@RequestParam String email, @RequestParam String password) {
		return userProfileService.emailAndPassCheck(email, password);
	}

	@GetMapping("/OTP")
	public String otpCheck(@RequestParam String email) throws Exception {
		return userProfileService.otpCheck(email);
	}
	
	@GetMapping("/clientEmailCheck")
	public boolean clientCheck(@RequestParam String emailID) {
		return userProfileService.clientCheck(emailID);		
	}

	@GetMapping("/clientAllDetails")
	public ClientEntity clientDetails(@RequestParam String emailID) {
		return userProfileService.clientDetails(emailID);		
	}

	@GetMapping("/getAllUserProfile")
	public List<UserProfileEntity> getAllUserProfile() {
		return userProfileService.getAllUserProfile();
	}
        
	@GetMapping("/getUserActivity/{id}")
	public UserProfileEntity getUserActivity(@PathVariable int id) {
		return userProfileService.getUserActivity(id);
	}

	@GetMapping("/forgotUser")
	public boolean forgotUser(@RequestParam String email, @RequestParam String mobile) {
		return userProfileService.forgotUser(email, mobile);
	}

	@GetMapping("/forgetPass")
	public boolean forgetPassword(@RequestParam String email, @RequestParam String password) {
		return userProfileService.changePassword(email, password);
	}

	@GetMapping("/emailNames/{email}")
	public List<UserProfileEntity> emailNames(@PathVariable String email) {
		return userProfileService.emailNames(email);
	}

}
