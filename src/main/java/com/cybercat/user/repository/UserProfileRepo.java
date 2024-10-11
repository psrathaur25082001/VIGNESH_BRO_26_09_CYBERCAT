package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.UserProfileEntity;

@Repository
public interface UserProfileRepo extends MongoRepository<UserProfileEntity, Integer> {

	boolean existsByEmail(String email);

	boolean existsByEmailAndPassword(String email, String password);

	UserProfileEntity findByEmailAndMobile(String email, String mobile);

	UserProfileEntity findByEmail(String email);

}
