package com.cybercat.user.entity;

import lombok.Data;

@Data
public class AgentAccessEntity {

	boolean userCreateBroker;	
	boolean userCreateClient;		
	boolean menuDashboard;
	boolean menuClient;
	boolean menuUserMangement;	
	boolean clientDetailsBtnResendlink;
	boolean clientDetailsBtnClientReport;
	boolean clientDetailsBtnTermSheet;
	boolean clientDetailsTabCriticalValueSubTabPolicyAnalyis;
	boolean clientDetailsTabCriticalValueSubTabRiskVariable;
	boolean clientDetailsTabCriticalValueSubTabVAR;
	boolean clientDetailsTabCriticalValueSubTabVarBrackup;
	boolean clientDetailsTabPolicyAdminSumInsured;	
	boolean reportDownloadTableOfContenets;
	boolean reportDownloadTableOfReportDefinition;
	boolean reportDownloadTableOfRiskMaterialRating;
	boolean reportDownloadTableOfMaterialRatingAndVar;
	boolean reportDownloadTableOfCyberRiskRating;
	boolean reportDownloadTableOfImmunityIndicator;
	boolean reportDownloadTableOfTechnicalAssessment;
	boolean reportDownloadTableOfGraphicalPresentationOfCyberScore;
	boolean reportDownloadTableOfIndustyComparison;
	boolean reportDownloadTableOfMetricesSuggestedAction;
	boolean reportDownloadTableOfGlobalCyberTrends;
	boolean reportDownloadTableOfAboutCybercat;
	boolean reportDownloadTableOfDisclaimer;
	boolean reportDownloadTableOfExtortion;
	boolean reportDownloadTableOfSolvency;
	boolean userCreateclientQuestionnaireTypePRO;
	boolean userCreateclientQuestionnaireTypePREMIUM;
	boolean userCreateclientQuestionnaireTypeFISH;
	boolean userListpageactionbtnEDIT;
}

