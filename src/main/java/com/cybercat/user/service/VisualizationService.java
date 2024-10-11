package com.cybercat.user.service;

import java.util.List;

import com.cybercat.user.entity.VisualizationEntity;

public interface VisualizationService {

	VisualizationEntity createVisualization(VisualizationEntity visualization);

	List<VisualizationEntity> getVisualization();

}
