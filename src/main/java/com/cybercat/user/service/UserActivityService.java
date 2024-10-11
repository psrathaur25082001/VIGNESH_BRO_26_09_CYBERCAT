package com.cybercat.user.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.cybercat.user.entity.UserActivityEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface UserActivityService {

	UserActivityEntity getUserActivity(int id);

    UserActivityEntity createUserActivity(HttpServletRequest request, UserActivityEntity activity) throws UnknownHostException, IOException;

	List<UserActivityEntity> getUser();

//	UserActivityEntity create(UserActivityEntity activity) throws UnknownHostException;

}
