/**
 * 
 */
package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.EntityList;

@Repository
public interface EntityRepo extends MongoRepository<EntityList, Integer> {

}
