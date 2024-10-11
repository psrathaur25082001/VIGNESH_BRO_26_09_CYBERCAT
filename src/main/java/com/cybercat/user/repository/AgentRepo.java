package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.AgentEntity;

@Repository
public interface AgentRepo extends MongoRepository<AgentEntity, Integer> {

	AgentEntity findByCreatedTime(String localTime);

}