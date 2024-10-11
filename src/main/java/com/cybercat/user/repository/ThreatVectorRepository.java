package com.cybercat.user.repository;

import com.cybercat.user.entity.ThreatVector;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThreatVectorRepository extends MongoRepository<ThreatVector,Integer> {

}
