package com.cybercat.user.serviceImpl;

import com.cybercat.user.entity.*;
import com.cybercat.user.repository.*;
import com.cybercat.user.service.GRVisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GRVisualizationServiceImpl implements GRVisualizationService {

    @Autowired
    private StrategicResponseRepo strategicRepo;
    
    @Autowired
    private IndustryResponseRepo industryRepo;

    @Autowired
    private HippaResponseRepo hippaRepo;

    @Autowired
    private TechnicalResponseRepo technicalRepo;
    
    @Autowired
    private GRVisualizationRepository grVisualizationRepository;

    @Override
    public GRVisualization_Entity get_average(int id) {
        Optional<GRVisualization_Entity> optionalGRAverage = grVisualizationRepository.findById(id);
        return optionalGRAverage.orElse(null);
    }


//    @Override
//    public GRVisualization_Entity getHeadAndScores(int clientId) {
//        GRVisualization_Entity result = new GRVisualization_Entity();
//        result.setType("risk_score_values");
//
//        // Strategic Response
//        Optional<StrategicResponseEntity> strategicResponseOptional = strategicRepo.findById(clientId);
//        if (strategicResponseOptional.isPresent()) {
//            StrategicResponseEntity strategicResponse = strategicResponseOptional.get();
//            result.getCr_score().addAll(getScoresForHead(strategicResponse, "CR"));
//            result.getRa_score().addAll(getScoresForHead(strategicResponse, "RA"));
//            result.getRct_score().addAll(getScoresForHead(strategicResponse, "RCT"));
//            result.getRda_score().addAll(getScoresForHead(strategicResponse, "RDA"));
//        }
//        
//        // Industry Response
//        Optional<IndustryResponseEntity> industryResponseOptional = industryRepo.findById(clientId);
//        if (industryResponseOptional.isPresent()) {
//            IndustryResponseEntity industryResponse = industryResponseOptional.get();
//            result.getCr_score().addAll(getScoresForHead(industryResponse, "CR"));
//            result.getRa_score().addAll(getScoresForHead(industryResponse, "RA"));
//            result.getRct_score().addAll(getScoresForHead(industryResponse, "RCT"));
//            result.getRda_score().addAll(getScoresForHead(industryResponse, "RDA"));
//        }
//
//        // HIPAA Response
//        Optional<HippaResponseEntity> hippaResponseOptional = hippaRepo.findById(clientId);
//        if (hippaResponseOptional.isPresent()) {
//            HippaResponseEntity hippaResponse = hippaResponseOptional.get();
//            result.getCr_score().addAll(getScoresForHead(hippaResponse, "CR"));
//            result.getRa_score().addAll(getScoresForHead(hippaResponse, "RA"));
//            result.getRct_score().addAll(getScoresForHead(hippaResponse, "RCT"));
//            result.getRda_score().addAll(getScoresForHead(hippaResponse, "RDA"));
//            
//        }
//
//        // Technical Response
//        Optional<TechnicalResponseEntity> technicalResponseOptional = technicalRepo.findById(clientId);
//        if (technicalResponseOptional.isPresent()) {
//            TechnicalResponseEntity technicalResponse = technicalResponseOptional.get();
//            result.getCr_score().addAll(getScoresForHead(technicalResponse, "CR"));
//            result.getRa_score().addAll(getScoresForHead(technicalResponse, "RA"));
//            result.getRct_score().addAll(getScoresForHead(technicalResponse, "RCT"));
//            result.getRda_score().addAll(getScoresForHead(technicalResponse, "RDA"));
//        }
//
//        return result;
//    }
//
//    private List<Integer> getScoresForHead(StrategicResponseEntity response, String head) {
//        List<Integer> scores = new ArrayList<>();
//
//        if (response.getStrResponses() == null) {
//            return scores;
//        }
//
//        for (StrategicQuestionResponseEntity questionResponse : response.getStrResponses()) {
//            if (questionResponse.getHead() == null) {
//                continue;
//            }
//
//            if (questionResponse.getHead().equalsIgnoreCase(head)) {
//                Integer score = questionResponse.getScore();
//                if (score != null) {
//                    scores.add(score);
//                } 
//            }
//        }
//
//        return scores;
//    }
//
//    private List<Integer> getScoresForHead(IndustryResponseEntity response, String head) {
//        List<Integer> scores = new ArrayList<>();
//
//        if (response.getIndResponses() == null) {
//            return scores;
//        }
//
//        for (IndustryQuestionResponseEntity questionResponse : response.getIndResponses()) {
//            if (questionResponse.getHead() == null) {
//                continue;
//            }
//
//            if (questionResponse.getHead().equalsIgnoreCase(head)) {
//                Integer score = questionResponse.getScore();
//                if (score != null) {
//                    scores.add(score);
//                } 
//            }
//        }
//
//        return scores;
//    }
//
//    private List<Integer> getScoresForHead(HippaResponseEntity response, String head) {
//                List<Integer> scores = new ArrayList<>();
//
//        if (response.getHippaResponses() == null) {
//        return scores;
//        }
//
//        for (HippaQuestionResponseEntity questionResponse : response.getHippaResponses()) {
//            if (questionResponse.getHead() == null) {
//            continue;
//            }
//
//            if (questionResponse.getHead().equalsIgnoreCase(head)) {
//                Integer score = questionResponse.getScore();
//                if (score != null) {
//                    scores.add(score);
//                   
//                }
//            }
//        }
//
//        return scores;
//    }
//
//    private List<Integer> getScoresForHead(TechnicalResponseEntity response, String head) {
//        System.out.println("Fetching scores for head: " + head);
//        List<Integer> scores = new ArrayList<>();
//
//        if (response.getTechResponses() == null) {
//                      return scores;
//        }
//
//        for (TechnicalQuestionResponseEntity questionResponse : response.getTechResponses()) {
//            if (questionResponse.getHead() == null) {
//                continue;
//            }
//
//            if (questionResponse.getHead().equalsIgnoreCase(head)) {
//                Integer score = questionResponse.getScore();
//                if (score != null) {
//                    scores.add(score);
//                } else {
//                }
//            }
//        }
//
//        return scores;
//    }
//    
//    @Override
//    public void saveAveragesInDb(int clientId, Map<String, Double> averages) {
//        GRVisualization_Entity entity = new GRVisualization_Entity();
//        entity.setClientId(clientId);
//        entity.setCr(convertToDouble(averages.get("cr")));
//        entity.setRa(convertToDouble(averages.get("ra")));
//        entity.setRct(convertToDouble(averages.get("rct")));
//        entity.setRda(convertToDouble(averages.get("rda")));
//
//        grVisualizationRepository.save(entity);
//    }
//
//    private Double convertToDouble(Object value) {
//        if (value instanceof Double) {
//            return (Double) value;
//        } else if (value instanceof String) {
//            try {
//                return Double.parseDouble((String) value);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return null;
//    }

//	@Override
//	public GRVisualization_Entity> get_average(int id) {
//		Optional<GRVisualization_Entity> GRAverage = grVisualizationRepository.findById(id);
//		return GRAverage;
//	}
    
    }