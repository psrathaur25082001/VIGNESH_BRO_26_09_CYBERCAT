package com.cybercat.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientListRepository extends MongoRepository<ClientListRepository, String> 
{
    
}
