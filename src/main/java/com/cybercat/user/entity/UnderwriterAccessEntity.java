package com.cybercat.user.entity;

import lombok.Data;

@Data
public class UnderwriterAccessEntity {

	boolean userCreateBusinessUnderwriter;
	boolean userCreateBRV;
	boolean userCreateClaimApproval;
	boolean userCreateRegionalSuperAdmin;
	boolean userCreateAgent;
	boolean userCreateBroker;	
	boolean userCreateClient;	
	boolean menuDashboard;
	boolean menuClient;
	boolean menuEntityProfileMaintenance;
	boolean menuUserMangement;
	boolean menuCapitalAllocation;
	boolean clientDetailsTabAnswer;
	boolean clientDetailsTabTechAnswer;
	boolean clientDetailsTabIndustryBasedAnswer;
	boolean clientDetailsTabVisualization;
	boolean clientDetailsTabCriticalValue;
	boolean clientDetailsTabPolicyAdmin;
	boolean clientDetailsTabDocument;
	boolean clientDetailsTabClaimStatus;
	boolean clientDetailsTabClaimFrom;
	boolean clientDetailsAnswerTabExportAllDigital;
	boolean clientDetailsBtnResendlink;
	boolean clientDetailsBtnRegenerateReport;
	boolean clientDetailsBtnClientReport;
	boolean clientDetailsBtnTermSheet;
	boolean clientDetailsTabCriticalValueSubTabRiskVariable;
	boolean clientDetailsTabCriticalValueSubTabVAR;
	boolean clientDetailsTabCriticalValueSubTabClickChangeDayTime;
	boolean clientDetailsTabCriticalValueSubTabVarBrackup;
	boolean clientDetailsTabPolicyAdminPolicyType;
	boolean clientDetailsTabPolicyAdminSumInsured;
	boolean clientDetailsTabPolicyAdminPremiumRange;
	boolean reportDownloadTableOfContenets;
	boolean reportDownloadTableOfReportDefinition;
	boolean reportDownloadTableOfRiskMaterialRating;
	boolean reportDownloadTableOfMaterialRatingAndVar;
	boolean reportDownloadTableOfCyberRiskRating;
	boolean reportDownloadTableOfImmunityIndicator;
	boolean reportDownloadTableOfTechnicalAssessmnet;
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
	boolean userListpageactionbtnSTATUS;
	boolean userListpageactionbtnDELETE;
	boolean clientListpagePolicyStatus;
}

