package com.cybercat.user.service;

import java.io.IOException;
import java.util.List;

import com.cybercat.user.helper.TreatyCapacity;
import com.cybercat.user.payload.PolicyTreatyPercentageDto;
import com.cybercat.user.payload.SolvencyRiskDto;
import org.apache.tomcat.util.http.parser.EntityTag;
import org.springframework.web.multipart.MultipartFile;

import com.cybercat.user.entity.EntityList;

public interface EntityService {

	int getTotalNumberOfClients();

	List<EntityList> getEntity();

	EntityList editEntity(EntityList underwriter, int id) throws Exception;

	EntityList deleteEntity(int id);

//	EntityList createEntity(EntityList underwriter);

	EntityList createEntity(EntityList underwriter, MultipartFile file) throws IOException;

	TreatyCapacity getTreatyByEntityId(int entityId);
	EntityList updatePolicyTreatyPercentage(PolicyTreatyPercentageDto dto);
	SolvencyRiskDto calculateSolvencyRisk(int entityId);

}
