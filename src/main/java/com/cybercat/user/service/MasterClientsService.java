package com.cybercat.user.service;

import java.util.List;

import com.cybercat.user.entity.CyberProEntity;
import com.cybercat.user.entity.CyberSMEEntity;
import com.cybercat.user.entity.InsuranceEntity;

public interface MasterClientsService {
	
	List<InsuranceEntity> getInsurance();

	List<CyberSMEEntity> getSMEIndustry();

	List<CyberSMEEntity> getSMEDivisions(String divisions);

	List<CyberSMEEntity> getSMEGroups(String groups);

	List<CyberProEntity> getProIndustry();

	List<CyberProEntity> getProSector(String sector);

	List<CyberProEntity> getProSubIndustry(String subIndustry);

}
