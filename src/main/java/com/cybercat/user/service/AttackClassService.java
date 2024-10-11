package com.cybercat.user.service;

import java.util.List;
import java.util.Optional;

import com.cybercat.user.entity.AttackClassEntity;
import com.cybercat.user.entity.AttackLibraryEntity;

public interface AttackClassService {

	List<AttackClassEntity> getAttackdata();

	AttackClassEntity addAttackClassdata(AttackClassEntity attackClassques);

	Optional<AttackClassEntity> attackClassid(int id);
	double findByAttackName(String attackName);

}
