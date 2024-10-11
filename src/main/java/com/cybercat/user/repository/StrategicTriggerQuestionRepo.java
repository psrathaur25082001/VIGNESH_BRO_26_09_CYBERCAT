package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.StrategicQuestionEntity;
import com.cybercat.user.entity.StrategicTriggerQuestionEntity;

@Repository
public interface StrategicTriggerQuestionRepo extends MongoRepository<StrategicTriggerQuestionEntity, String> {

	StrategicTriggerQuestionEntity findByName(String name);

	void save(StrategicQuestionEntity ques);

}
