package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.AttackLibraryEntity;

import java.util.List;

@Repository
public interface AttackLibraryRepo extends MongoRepository<AttackLibraryEntity,Integer> {

	void save(String count);

	 @Query(value = "{}", fields = "{ 'id': 1 }")
	Integer findMaxId();

	 List<AttackLibraryEntity> findByAttack(String attach);

}
