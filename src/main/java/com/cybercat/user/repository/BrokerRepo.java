package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.BrokerEntity;

@Repository
public interface BrokerRepo extends MongoRepository<BrokerEntity, Integer> {

	BrokerEntity findByCreatedTime(String localTime);

}