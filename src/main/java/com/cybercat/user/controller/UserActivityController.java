package com.cybercat.user.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybercat.user.entity.UserActivityEntity;
import com.cybercat.user.service.UserActivityService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user/activity")
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;

	@GetMapping("/getUserActivity/{id}")
	public UserActivityEntity getUserActivity(@PathVariable int id) {
		return userActivityService.getUserActivity(id);
	}

	@PostMapping("/createUserActivity")
	public UserActivityEntity createUserActivity(HttpServletRequest request, @RequestBody UserActivityEntity activity)
			throws IOException {
		return userActivityService.createUserActivity(request, activity);
	}

	@GetMapping("/getUser")
	public List<UserActivityEntity> getUser() {
		return userActivityService.getUser();
	}

//	@PostMapping("/create")
//	public ResponseEntity<UserActivityEntity> create(@RequestBody UserActivityEntity activity)
//			throws UnknownHostException {
//		UserActivityEntity createdActivity = userActivityService.create(activity);
//		return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
//	}

//	@PostMapping("/user")
//	public ResponseEntity<String> createUser(@RequestBody UserActivityEntity user) {
//		String ipAddress = request.getRemoteAddr();
//		System.out.println("User IP Address: " + ipAddress);
//		return ResponseEntity.ok("User created successfully");
//	}
}
