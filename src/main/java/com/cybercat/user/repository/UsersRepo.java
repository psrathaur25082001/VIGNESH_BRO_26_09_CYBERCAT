package com.cybercat.user.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.UsersEntity;

@Repository
public interface UsersRepo extends MongoRepository<UsersEntity, Integer> {

	List<UsersEntity> findByUserTypeIsLikeIgnoreCase(String value, Pageable pageable);

	UsersEntity findByCreatedTime(String localTime);

}
