package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.StrategicQuestionEntity;
@Repository
public interface StrategicQuestionRepository extends MongoRepository<StrategicQuestionEntity, Integer> 
{
   
}
