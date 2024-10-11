package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.BRVEntity;

@Repository
public interface BRVRepo extends MongoRepository<BRVEntity, Integer> {

	BRVEntity findByCreatedTime(String localTime);

}