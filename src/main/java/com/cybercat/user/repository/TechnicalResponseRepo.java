package com.cybercat.user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cybercat.user.entity.TechnicalResponseEntity;

@Repository
public interface TechnicalResponseRepo extends MongoRepository<TechnicalResponseEntity, Integer> {


}
