package com.cybercat.user.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
@Document(collection = "RCT_Average")
@Data
public class GRVisualization_Entity {
	
//    private String type;
//    @Transient 	//used to hide this json in in database
//    private List<Integer> cr_score = new ArrayList<>();
//    @Transient
//    private List<Integer> ra_score = new ArrayList<>();
//    @Transient
//    private List<Integer> rct_score = new ArrayList<>();
//    @Transient
//    private List<Integer> rda_score = new ArrayList<>();
    
    
    //here, clientId is assigned to mongodb "_id" not autogeneration
    @Id
//    @Field("clientId")    
    int id;
    private Double cr;
    private Double ra;
    private Double rct;
    private Double rda;

}