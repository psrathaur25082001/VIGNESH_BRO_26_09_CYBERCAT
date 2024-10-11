package com.cybercat.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.CyberProEntity;

@Repository
public interface CyberProRepo extends MongoRepository<CyberProEntity, Integer> {

	List<CyberProEntity> findByIndustryName(String sector);

	List<CyberProEntity> findBySector(String subIndustry);
}

