package com.cybercat.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CYBER-SME-MASTER")
public class CyberSMEEntity {

	@Id
    int id;
    String industry;
    String sections;
    String divisions;   
    String groups;
    String groupLevel;
}
