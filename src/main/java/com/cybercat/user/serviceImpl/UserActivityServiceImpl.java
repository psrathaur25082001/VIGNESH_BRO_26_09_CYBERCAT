package com.cybercat.user.serviceImpl;

import java.time.LocalDate;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.entity.UserActivityEntity;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.repository.UserActivityRepo;
import com.cybercat.user.service.UserActivityService;

import jakarta.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	UserActivityRepo userActivityRepo;

	@Autowired
	TriggerRepo triggerRepo;

	public UserActivityEntity getUserActivity(int id) {
		Optional<UserActivityEntity> optionalActivity = userActivityRepo.findById(id);
		if (optionalActivity.isPresent()) {
			UserActivityEntity activity = optionalActivity.get();
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

	public UserActivityEntity createUserActivity(HttpServletRequest request, UserActivityEntity activity)
			throws IOException {
		TriggerEntity trigger = triggerRepo.findByName("userActivity");
		activity.setId(trigger.getCount() + 1);
		activity.setActiveDate(LocalDate.now().toString());
		LocalDateTime now = LocalDateTime.now();
		activity.setActiveTime(now.toString());
		LocalDateTime activityTime = LocalDateTime.parse(activity.getActiveTime());
		Duration duration = Duration.between(activityTime, now);
		long minutesDifference = duration.toMinutes();
		activity.setActiveTimeDescription(minutesDifference + " mins ago");

//	        LocalTime activeHour = now.toLocalTime().truncatedTo(java.time.temporal.ChronoUnit.HOURS);
//	        activity.setActiveHour(activeHour.toString());	  

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String activeHour = now.format(formatter);
		activity.setActiveHour(activeHour);

		String publicIPAddress = getPublicIPAddress();
		activity.setUserIpAddress(publicIPAddress);

		userActivityRepo.save(activity);
		trigger.setCount(trigger.getCount() + 1);
		triggerRepo.save(trigger);
		return activity;
	}

	public List<UserActivityEntity> getUser() {
		return userActivityRepo.findAll();
	}

	private static String getPublicIPAddress() throws IOException {
		URL url = new URL("http://checkip.amazonaws.com");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String ipAddress = br.readLine().trim();
		br.close();
		return ipAddress;
	}

//	public UserActivityEntity create(UserActivityEntity activity) throws UnknownHostException {
//		InetAddress inetAddress = InetAddress.getLocalHost();
//		String ipAddress1 = inetAddress.getHostAddress();
//		System.out.println("IP Address: " + ipAddress1);
//		activity.setUserIpAddress(ipAddress1);
//		return userActivityRepo.save(activity);
//	}

}
