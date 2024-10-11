package com.cybercat.user.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("t_capital_allcation")
public class CapitalAllocation {
    private int id;
    private String industryName;
    private String allocatedCapital;
    private String availableCapital;
    private String reInsuranceRisk;
    private String retainedRisk;
    private String utilizedPercentage;

}
