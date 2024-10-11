package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.UserActivityEntity;

@Repository
public interface UserActivityRepo extends MongoRepository<UserActivityEntity, Integer> {

}
