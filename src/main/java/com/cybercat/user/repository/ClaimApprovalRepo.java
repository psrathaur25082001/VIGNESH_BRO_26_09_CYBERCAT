package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.ClaimApprovalEntity;

@Repository
public interface ClaimApprovalRepo extends MongoRepository<ClaimApprovalEntity, Integer> {

	ClaimApprovalEntity findByCreatedTime(String localTime);

}