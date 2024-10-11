package com.cybercat.user.controller;

import com.cybercat.user.entity.GRVisualization_Entity;
import com.cybercat.user.service.GRVisualizationService;
import com.cybercat.user.service.PythonApiService_RTC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/visualization")
@CrossOrigin
public class GRVisualizationController {

    @Autowired
    private GRVisualizationService grVisualizationService;

    @Autowired
    private PythonApiService_RTC pythonApiService;

//    @GetMapping("/head-scores/{clientId}")
//    
//    public GRVisualization_Entity getHeadAndScores(@PathVariable("clientId") int clientId) {
//        GRVisualization_Entity entity = grVisualizationService.getHeadAndScores(clientId);
//
//        Map<String, List<Integer>> scores = new HashMap<>();
//        scores.put("cr_score", entity.getCr_score());
//        scores.put("ra_score", entity.getRa_score());
//        scores.put("rct_score", entity.getRct_score());
//        scores.put("rda_score", entity.getRda_score());
//        return entity;
//    }
//    @SuppressWarnings("unchecked")
//    @PostMapping("/save-averages/{clientId}")
//   
//    public String saveAverages(@PathVariable("clientId") int clientId, @RequestBody Map<String, Object> scores) {
//        
//        Map<String, List<Integer>> scoresMap = new HashMap<>();
//        scoresMap.put("cr_score", (List<Integer>) scores.get("cr_score"));
//        scoresMap.put("ra_score", (List<Integer>) scores.get("ra_score"));
//        scoresMap.put("rct_score", (List<Integer>) scores.get("rct_score"));
//        scoresMap.put("rda_score", (List<Integer>) scores.get("rda_score"));
//
//        Map<String, Double> averages = pythonApiService.getAverages(scoresMap);
//        saveAveragesInDb(clientId, averages);
//        return "Averages saved successfully!";
//    }
//
//    private void saveAveragesInDb(int clientId, Map<String, Double> averages) {
//        grVisualizationService.saveAveragesInDb(clientId, averages);
//    }
//    
//    @SuppressWarnings("unchecked")
//    @PutMapping("/edit-averages/{clientId}")
//    public String saveAverages1(@PathVariable("clientId") int clientId, @RequestBody Map<String, Object> scores) {
//        
//        Map<String, List<Integer>> scoresMap = new HashMap<>();
//        scoresMap.put("cr_score", (List<Integer>) scores.get("cr_score"));
//        scoresMap.put("ra_score", (List<Integer>) scores.get("ra_score"));
//        scoresMap.put("rct_score", (List<Integer>) scores.get("rct_score"));
//        scoresMap.put("rda_score", (List<Integer>) scores.get("rda_score"));
//
//        Map<String, Double> averages = pythonApiService.getAverages(scoresMap);
//        saveAveragesInDb(clientId, averages);
//        return "Averages saved successfully!";
//    }
     
    @GetMapping("/get-average")
    public ResponseEntity<List<GRVisualization_Entity>> get_average(@RequestParam int id) {
        List<GRVisualization_Entity> entities = Collections.singletonList(grVisualizationService.get_average(id));
        return ResponseEntity.ok(entities);
    }

    

}
