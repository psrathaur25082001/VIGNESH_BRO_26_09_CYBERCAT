package com.cybercat.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybercat.user.entity.VisualizationEntity;
import com.cybercat.user.service.VisualizationService;

@RestController
@RequestMapping("/visualization")
public class VisualizationController {

	@Autowired
	VisualizationService visualizationComponentService;
	
	@PostMapping("/createVisualization")
	public VisualizationEntity createVisualization(@RequestBody VisualizationEntity visualization) {
		return visualizationComponentService.createVisualization(visualization);
	}

	@GetMapping("/getVisualization")
	public List<VisualizationEntity> getVisualization() {
		return visualizationComponentService.getVisualization();
	}
}
