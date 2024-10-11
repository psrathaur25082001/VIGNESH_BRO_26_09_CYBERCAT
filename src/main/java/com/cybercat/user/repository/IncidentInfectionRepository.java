package com.cybercat.user.repository;

import com.cybercat.user.entity.IncidentInfection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IncidentInfectionRepository extends MongoRepository<IncidentInfection,Integer> {
   List<IncidentInfection> findByIndustryType(String industryType);
}
