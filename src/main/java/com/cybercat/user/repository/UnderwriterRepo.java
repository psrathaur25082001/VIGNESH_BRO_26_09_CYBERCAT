package com.cybercat.user.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.MultipleUsersListEntity;
import com.cybercat.user.entity.UnderwriterEntity;

@Repository
public interface UnderwriterRepo extends MongoRepository<UnderwriterEntity, Integer> {

	List<UnderwriterEntity> findByUserTypeIsLikeIgnoreCase(String value, Pageable pageable);

	UnderwriterEntity findByCreatedTime(String localTime);

}

