package com.cybercat.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.AttackClassEntity;

@Repository
public interface AttackClassRepo extends MongoRepository<AttackClassEntity, Integer> {

	List<AttackClassEntity> findById(String id);
	AttackClassEntity findByAttackName(String attackName);


}
