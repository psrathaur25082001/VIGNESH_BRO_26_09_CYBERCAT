package com.cybercat.user.repository;

import com.cybercat.user.entity.GRVisualization_Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GRVisualizationRepository extends MongoRepository<GRVisualization_Entity, Integer> {

}
