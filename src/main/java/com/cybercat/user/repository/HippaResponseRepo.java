package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.HippaResponseEntity;

@Repository
public interface HippaResponseRepo extends MongoRepository<HippaResponseEntity, Integer> {

}

