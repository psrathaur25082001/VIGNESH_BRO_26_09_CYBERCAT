package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.PremiumTableEntity;

public interface PremiumTableRepo extends MongoRepository<PremiumTableEntity,Integer> {

	PremiumTableEntity save(AttackClassEntity addPremiumData);

}
