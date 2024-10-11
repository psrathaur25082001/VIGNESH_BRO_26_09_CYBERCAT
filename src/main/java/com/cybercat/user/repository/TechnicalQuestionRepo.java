package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.TechnicalQuestionEntity;

@Repository
public interface TechnicalQuestionRepo extends MongoRepository<TechnicalQuestionEntity, Integer> {

}
