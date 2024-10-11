package com.cybercat.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolvencyRiskDto {
    private int entityId;
    private String chargedPremium;
    private String solvencyIncreasedRisk;
    private String industryCapitalAllocated;
    private String availableIndustryCapital;
    private String availableIndustryCapitalAfterPolicy;
    private String minimumSumInsured;
    private String baseSolvency;
    private String solvencyCumulativeRisk;
}
