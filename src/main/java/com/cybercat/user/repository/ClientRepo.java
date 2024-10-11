package com.cybercat.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cybercat.user.entity.ClientEntity;

@Repository
public interface ClientRepo extends MongoRepository<ClientEntity, Integer> {

	List<ClientEntity> findByUserTypeIsLikeIgnoreCase(String value, Pageable pageable);

	ClientEntity findByCreatedTime(String localTime);

	boolean existsById(String id);

	List<ClientEntity> findById(String clientID);

	boolean existsByEmailID(String emailID);

	ClientEntity findByEmailID(String emailID);

}
