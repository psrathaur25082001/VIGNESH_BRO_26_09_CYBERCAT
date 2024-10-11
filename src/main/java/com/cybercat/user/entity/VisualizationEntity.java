package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "VISUALIZATION" )
public class VisualizationEntity {

	@Id
	String id;	
	@Field(name="BFSI")
	String bFSI;
	@Field(name="Technology")
	String technology;
	@Field(name="Pharmaceuticals")
	String pharmaceuticals;
	@Field(name="Manufacturing")
	String manufacturing;
	@Field(name="OilAndGas")
	String oilAndGas;
	@Field(name="Other")
	String other;
}
