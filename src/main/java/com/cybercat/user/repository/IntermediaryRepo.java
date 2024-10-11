package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.IntermediaryEntity;

@Repository
public interface IntermediaryRepo extends MongoRepository<IntermediaryEntity, Integer> {

	IntermediaryEntity findByCreatedTime(String localTime);

}
