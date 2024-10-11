package com.cybercat.user.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.entity.UserActivityEntity;
import com.cybercat.user.entity.UserProfileEntity;
import com.cybercat.user.helper.GenerateSecurityKey;
import com.cybercat.user.helper.SendMailOTP;
import com.cybercat.user.repository.ClientRepo;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.repository.UserProfileRepo;
import com.cybercat.user.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepo userProfileRepo;

	@Autowired
	TriggerRepo triggerRepo;
	
	@Autowired
	ClientRepo clientRepo;

	public UserProfileEntity createUserProfile(UserProfileEntity profile) throws IOException {
		TriggerEntity trigger = triggerRepo.findByName("userProfile");
		profile.setId(trigger.getCount() + 1);
		profile.setActiveDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		profile.setActiveTime(now.toString());

		LocalDateTime activityTime = LocalDateTime.parse(profile.getActiveTime());
		Duration duration = Duration.between(activityTime, now);
		long minutesDifference = duration.toMinutes();
		 profile.setActiveTimeDescription(minutesDifference + " mins ago");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String activeHour = now.format(formatter);
		profile.setActiveHour(activeHour);

		String publicIPAddress = getPublicIPAddress();
		profile.setUserIpAddress(publicIPAddress);
		profile.setInitiatedDate(LocalDate.now().toString());
		userProfileRepo.save(profile);
		trigger.setCount(trigger.getCount() + 1);
		triggerRepo.save(trigger);
		return profile;
	}

	private static String getPublicIPAddress() throws IOException {
		URL url = new URL("http://checkip.amazonaws.com");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String ipAddress = br.readLine().trim();
		br.close();
		return ipAddress;
	}

	public boolean emailCheck(String email) {
		return userProfileRepo.existsByEmail(email);
	}

	public boolean emailAndPassCheck(String email, String password) {
		return userProfileRepo.existsByEmailAndPassword(email, password);
	}

	public String otpCheck(String email) throws Exception {
		String key = GenerateSecurityKey.main();
		SendMailOTP.mailSend(email, key);
		System.out.println(key);
		return key;
	}

//	public List<UserProfileEntity> getAllUserProfile() {
//		return userProfileRepo.findAll();
//	}

	public List<UserProfileEntity> getAllUserProfile() {
		List<UserProfileEntity> clients = userProfileRepo.findAll();

		for (UserProfileEntity cl : clients) {
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime activityTime = LocalDateTime.parse(cl.getActiveTime());

			Duration duration = Duration.between(activityTime, now);
			long minutesDifference = duration.toMinutes();

			String description;
			if (minutesDifference < 1) {
				description = "just now";
			} else if (minutesDifference < 60) {
				description = minutesDifference + " mins ago";
			} else {
				long days = duration.toDays();
				long hours = duration.minusDays(days).toHours();
				description = days + " days " + hours + " hrs ago";
			}
			
			String activeTimeDescription = (description);
//			String activeTimeDescription = (minutesDifference == 0) ? "just now" : minutesDifference + " mins ago";
			cl.setActiveTimeDescription(activeTimeDescription);
		}

		return clients;
	}

	public UserProfileEntity getUserActivity(int id) {
		Optional<UserProfileEntity> optionalActivity = userProfileRepo.findById(id);
		if (optionalActivity.isPresent()) {
			UserProfileEntity activity = optionalActivity.get();
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime activityTime = LocalDateTime.parse(activity.getActiveTime());
			Duration duration = Duration.between(activityTime, now);
			long minutesDifference = duration.toMinutes();
			String activeTimeDescription = (minutesDifference == 0) ? "just now" : minutesDifference + " mins ago";
			activity.setActiveTimeDescription(activeTimeDescription);

			return activity;
		} else {
			return null;
		}
	}

	public boolean forgotUser(String email, String mobile) {
		UserProfileEntity user = userProfileRepo.findByEmailAndMobile(email, mobile);
		if (user.getEmail().equals(email) && user.getMobile().equals(mobile)) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean clientCheck(String emailID) {
		if (clientRepo.existsByEmailID(emailID)) {
			return true;
		} else {
			return false;
		}
	}

	public ClientEntity clientDetails(String emailID) {
		if (clientRepo.existsByEmailID(emailID)) {
			return clientRepo.findByEmailID(emailID);
		} else {
			return null;
		}
	}

	public boolean changePassword(String email, String password) {
		UserProfileEntity user = userProfileRepo.findByEmail(email);
		user.setPassword(password);
		userProfileRepo.save(user);
		return true;
	}

	public List<UserProfileEntity> emailNames(String email) {
		return userProfileRepo.findAll();
	}

}
