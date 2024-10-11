package com.cybercat.user.service;

import java.io.IOException;
import java.util.List;

import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.UserProfileEntity;

public interface UserProfileService {

	UserProfileEntity createUserProfile(UserProfileEntity profile) throws IOException;
	
	boolean emailCheck(String email);

	boolean emailAndPassCheck(String email, String password);

	List<UserProfileEntity> emailNames(String email);

	String otpCheck(String email) throws Exception;

	boolean forgotUser(String email, String mobile);

	boolean changePassword(String email, String password);

	List<UserProfileEntity> getAllUserProfile();

	UserProfileEntity getUserActivity(int id);

	ClientEntity clientDetails(String emailID);

	boolean clientCheck(String emailID);

}
