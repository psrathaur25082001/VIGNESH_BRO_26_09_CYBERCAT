package com.cybercat.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.PremiumTableEntity;
import com.cybercat.user.repository.PremiumTableRepo;
import com.cybercat.user.service.PremiumTableService;

@Service
public class PremiumTableServiceImpl implements PremiumTableService{
	
	@Autowired
	PremiumTableRepo premiumTableRepo;

	@Override
	public List<PremiumTableEntity> Premiumdata() {
		return premiumTableRepo.findAll();
	}

	@Override
	public Optional<PremiumTableEntity> PremiumdataId(int id) {
		return premiumTableRepo.findById(id);
	}

	@Override
	public PremiumTableEntity addPremiumTabledata(PremiumTableEntity addPremiumData) {
		int maximumId = findmaxId();
		addPremiumData.setId(maximumId + 1);
		return premiumTableRepo.save(addPremiumData);
	}
	private int findmaxId() {
		return premiumTableRepo.findAll(Sort.by(Sort.Order.desc("id")))
                .stream()
                .findFirst()
                .map(PremiumTableEntity::getId)
                .orElse(0); 
	}

}
