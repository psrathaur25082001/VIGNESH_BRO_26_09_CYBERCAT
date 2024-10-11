package com.cybercat.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PythonApiService_RTC {

    public Map<String, Double> getAverages(Map<String, List<Integer>> scores) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://8020-122-165-188-82.ngrok-free.app/get_metrics";
        Map<String, Object> request = new HashMap<>();
        request.put("type", "risk_score_values");
        request.put("cr_score", scores.get("cr_score"));
        request.put("ra_score", scores.get("ra_score"));
        request.put("rct_score", scores.get("rct_score"));
        request.put("rda_score", scores.get("rda_score"));
        @SuppressWarnings("unchecked")
        Map<String, Double> response = restTemplate.postForObject(url, request, Map.class);
        return response;
    }
}
