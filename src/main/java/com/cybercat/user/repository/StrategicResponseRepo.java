package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.StrategicResponseEntity;

@Repository
public interface StrategicResponseRepo extends MongoRepository<StrategicResponseEntity, Integer> {

	StrategicResponseEntity findById(String clientId);

}
