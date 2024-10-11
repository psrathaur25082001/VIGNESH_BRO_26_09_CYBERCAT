package com.cybercat.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("t_incident_infection")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidentInfection {
    @Id
    private int incidentInfectionId;
    private String incidentCategory;
    private String relevantIncidentDescription;
    private String incidentCode;
    private int days;
    private String incidentCriticality;
    private String industryType;
    private int year;
    private Date detectedMonthYear;
    private String incidentCount;
    private String geogSpread;
    private String remark;
}
