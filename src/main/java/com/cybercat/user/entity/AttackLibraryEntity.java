package com.cybercat.user.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection="ATTACK_LIBRARY_DATA")
@Data
public class AttackLibraryEntity {
	@Id
	int id;
	String date;
	String author;
	String target;
	String description;
	String type;
	String industrytarget;
	String industry;
	String attack;
	String country;
	String criticality;
}
