package com.cybercat.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercat.user.entity.VisualizationEntity;
import com.cybercat.user.repository.VisualizationRepo;
import com.cybercat.user.service.VisualizationService;

@Service
public class VisualizationServiceImpl implements VisualizationService {

	@Autowired
	VisualizationRepo visualizationrRepo;
	
	public VisualizationEntity createVisualization(VisualizationEntity visualization) {
		return visualizationrRepo.save(visualization);
	}
	
	public List<VisualizationEntity> getVisualization() {
		return visualizationrRepo.findAll();
	}

}
