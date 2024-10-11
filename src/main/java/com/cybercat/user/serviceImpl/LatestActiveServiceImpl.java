package com.cybercat.user.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.LatestActiveEntity;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.repository.LatestActiveRepo;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.LatestActiveService;

@Service
public class  LatestActiveServiceImpl implements LatestActiveService{

	@Autowired
	LatestActiveRepo latestActiveRepo;
	
	@Autowired
	TriggerRepo triggerRepo;
	
	public List<LatestActiveEntity> getLatestActive() {
		return latestActiveRepo.findAll();
	}

	public LatestActiveEntity createLatestActive(LatestActiveEntity latest) {
        TriggerEntity trigger = triggerRepo.findByName("latestActive");
        latest.setId(trigger.getCount() + 1);	   
        latest.setInitiatedDate(LocalDate.now().toString());
        latestActiveRepo.save(latest);	        
        trigger.setCount(trigger.getCount() + 1);
        triggerRepo.save(trigger);	        
        return latest;
	}

}
