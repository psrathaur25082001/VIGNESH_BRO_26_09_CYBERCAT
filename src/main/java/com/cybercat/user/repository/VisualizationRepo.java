package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.VisualizationEntity;

@Repository
public interface VisualizationRepo extends MongoRepository<VisualizationEntity, String> {

}
