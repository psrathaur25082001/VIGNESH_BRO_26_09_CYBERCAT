package com.cybercat.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("t_threat_vector")
public class ThreatVector {
    @Id
    private int threatVectorId;
    private String classificationOfActors;
    private String industryType;
    private String incident;
    private int days;

}
