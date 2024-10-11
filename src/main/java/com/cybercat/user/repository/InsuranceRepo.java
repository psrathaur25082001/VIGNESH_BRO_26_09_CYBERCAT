package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.InsuranceEntity;


@Repository
public interface InsuranceRepo  extends MongoRepository<InsuranceEntity, Integer>{

}
