package com.cybercat.user.service;

import com.cybercat.user.entity.GRVisualization_Entity;

import java.util.Map;
import java.util.Optional;

public interface GRVisualizationService {

	GRVisualization_Entity get_average(int id);
//    GRVisualization_Entity getHeadAndScores(int clientId);
//    void saveAveragesInDb(int clientId, Map<String, Double> averages);
//    Optional<GRVisualization_Entity> get_average(int id);
}
