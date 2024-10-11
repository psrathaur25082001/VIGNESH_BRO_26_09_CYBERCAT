package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.AddNewUserTrigger;

@Repository
public interface AddNewUserTriggerRepo extends MongoRepository<AddNewUserTrigger, String> {
	
	AddNewUserTrigger findByName(String name);

}
