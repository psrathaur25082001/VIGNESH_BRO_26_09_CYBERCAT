package com.cybercat.user.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.CyberProEntity;
import com.cybercat.user.entity.CyberSMEEntity;
import com.cybercat.user.entity.InsuranceEntity;
import com.cybercat.user.repository.CyberProRepo;
import com.cybercat.user.repository.CyberSMERepo;
import com.cybercat.user.repository.InsuranceRepo;
import com.cybercat.user.service.MasterClientsService;

@Service
public class MasterClientsServiceImpl implements MasterClientsService {

	@Autowired
	InsuranceRepo insuranceRepo;
	
	@Autowired
	CyberSMERepo cyberSMERepo;

	@Autowired
	CyberProRepo cyberProRepo;

	public List<InsuranceEntity> getInsurance() {
		System.out.println("fgf");
		return insuranceRepo.findAll();
	}
	
	// showing industry only
	public List<CyberSMEEntity> getSMEIndustry() {
		List<CyberSMEEntity> res = cyberSMERepo.findAll();
		List<String> temp = new ArrayList<>();
		res.forEach((vr) -> {
			temp.add(vr.getIndustry());
		});
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(temp);
		temp.clear();
		temp.addAll(primesWithoutDuplicates);
		res.clear();
		temp.forEach((w) -> {
			CyberSMEEntity t = new CyberSMEEntity();
			t.setIndustry(w);
			res.add(t);
		});
		return res;
	}

	public List<CyberSMEEntity> getSMEDivisions(String divisions) {
		List<CyberSMEEntity> res = cyberSMERepo.findByIndustry(divisions);
		return res;
	}

	public List<CyberSMEEntity> getSMEGroups(String groups) {
		List<CyberSMEEntity> res = cyberSMERepo.findByDivisions(groups);
		return res;
	}

	public List<CyberProEntity> getProIndustry() {
		List<CyberProEntity> res = cyberProRepo.findAll();
		List<String> temp = new ArrayList<>();
		res.forEach((vr) -> {
			temp.add(vr.getIndustryName());
		});
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(temp);
		temp.clear();
		temp.addAll(primesWithoutDuplicates);
		res.clear();
		temp.forEach((w) -> {
			CyberProEntity t = new CyberProEntity();
			t.setIndustryName(w);
			res.add(t);
		});
		return res;
	}

	public List<CyberProEntity> getProSector(String sector) {
		List<CyberProEntity> res = cyberProRepo.findByIndustryName(sector);
		return res;
	}

	public List<CyberProEntity> getProSubIndustry(String subIndustry) {
		List<CyberProEntity> res = cyberProRepo.findBySector(subIndustry);
		return res;
	}

}
