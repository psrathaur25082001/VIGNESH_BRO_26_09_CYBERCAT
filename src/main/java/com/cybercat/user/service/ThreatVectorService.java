package com.cybercat.user.service;

import com.cybercat.user.entity.ThreatVector;

import java.util.List;

public interface ThreatVectorService {
    ThreatVector saveThreat(ThreatVector threatVector);
    List<ThreatVector> getThreatList();
    double getTreatVector();
}
