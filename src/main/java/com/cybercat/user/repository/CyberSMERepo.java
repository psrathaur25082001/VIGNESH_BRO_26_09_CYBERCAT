package com.cybercat.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.CyberSMEEntity;

@Repository
public interface CyberSMERepo extends MongoRepository<CyberSMEEntity, Integer> {

	List<CyberSMEEntity> findByDivisions(String groups);

	List<CyberSMEEntity> findByIndustry(String divisions);

}
