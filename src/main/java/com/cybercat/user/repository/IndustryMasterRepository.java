package com.cybercat.user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.Industry_Master;

@Repository
public interface IndustryMasterRepository extends MongoRepository<Industry_Master, String> {



}