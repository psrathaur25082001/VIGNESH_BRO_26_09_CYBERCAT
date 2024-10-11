package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.LatestActiveEntity;

@Repository
public interface LatestActiveRepo extends MongoRepository<LatestActiveEntity, Integer> {

}
