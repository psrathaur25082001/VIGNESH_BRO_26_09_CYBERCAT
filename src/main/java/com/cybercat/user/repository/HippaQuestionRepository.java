package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.HippaQuestionEntity;

@Repository
public interface HippaQuestionRepository extends MongoRepository<HippaQuestionEntity, Integer> 
{
   
}

