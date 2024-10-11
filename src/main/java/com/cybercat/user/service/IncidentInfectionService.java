package com.cybercat.user.service;

import com.cybercat.user.entity.IncidentInfection;

import java.util.List;

public interface IncidentInfectionService {
    IncidentInfection saveIncidentInfection(IncidentInfection incidentInfection);
    List<IncidentInfection> findByIndustryTypeList(String industryType);
    double infectionRate(String industryType);
}
