package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TRIGGER")
public class TriggerEntity {

	@Id
	String id;
	String name;
	int count;
}
