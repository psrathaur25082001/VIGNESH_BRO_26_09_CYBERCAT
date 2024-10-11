package com.cybercat.user.repository;

import com.cybercat.user.entity.PremiumChargedAmount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PremiumChargedRepository extends MongoRepository<PremiumChargedAmount,Integer> {
       PremiumChargedAmount findByEntityId(int entityId);
}
