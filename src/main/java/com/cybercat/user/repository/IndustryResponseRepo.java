package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.IndustryResponseEntity;

@Repository
public interface IndustryResponseRepo extends MongoRepository<IndustryResponseEntity, Integer> {

}
