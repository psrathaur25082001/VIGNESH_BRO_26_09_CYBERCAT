package com.cybercat.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.AttackLibraryEntity;
import com.cybercat.user.repository.AttackClassRepo;
import com.cybercat.user.service.AttackClassService;
@Service
public class AttackClassServiceImpl implements AttackClassService {

	@Autowired
	AttackClassRepo attackClassRepo;
	
	public List<AttackClassEntity> getAttackdata() {
		return attackClassRepo.findAll();
}

	@Override
	public AttackClassEntity addAttackClassdata(AttackClassEntity attackClassques) {
		int maximumId = findmaxId();
		attackClassques.setId(maximumId + 1);
		return attackClassRepo.save(attackClassques);
	}

	private int findmaxId() {
		return attackClassRepo.findAll(Sort.by(Sort.Order.desc("id")))
                .stream()
                .findFirst()
                .map(AttackClassEntity::getId)
                .orElse(0); 
	}

	@Override
	public Optional<AttackClassEntity> attackClassid(int id) {
		return attackClassRepo.findById(id);
	}

	@Override
	public double findByAttackName(String attackName) {
		double attack_weight = attackClassRepo.findByAttackName(attackName).getAttack_weight();
		return attack_weight;
	}
}
