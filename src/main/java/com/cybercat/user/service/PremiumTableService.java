package com.cybercat.user.service;

import java.util.List;
import java.util.Optional;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.PremiumTableEntity;

public interface PremiumTableService {

	List<PremiumTableEntity> Premiumdata();

	Optional<PremiumTableEntity> PremiumdataId(int id);

	PremiumTableEntity addPremiumTabledata(PremiumTableEntity addPremiumData);

}
