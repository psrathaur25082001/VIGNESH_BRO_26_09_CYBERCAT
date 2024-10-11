package com.cybercat.user.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="ATTACK_CLASS")
@Data
public class AttackClassEntity {
	@Id
	int id;
	String AttackName;
	double Attack_weight;
}
