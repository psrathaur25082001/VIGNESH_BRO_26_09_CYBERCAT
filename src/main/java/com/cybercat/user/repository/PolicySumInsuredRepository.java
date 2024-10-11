package com.cybercat.user.repository;

import com.cybercat.user.entity.PolicySumInsured;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PolicySumInsuredRepository extends MongoRepository<PolicySumInsured,Integer> {

    PolicySumInsured findByEntityId(int entityId);

}
