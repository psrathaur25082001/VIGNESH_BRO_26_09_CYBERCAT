package com.cybercat.user.serviceImpl;

import com.cybercat.user.entity.ThreatVector;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.repository.ThreatVectorRepository;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.AttackClassService;
import com.cybercat.user.service.AttackLibraryService;
import com.cybercat.user.service.ThreatVectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class ThreatVectorServiceImpl implements ThreatVectorService {
    @Autowired
    private ThreatVectorRepository threatVectorRepository;
    @Autowired
    TriggerRepo triggerRepo;
    @Autowired
    AttackLibraryService attackLibraryService;
    @Autowired
    AttackClassService attackClassService;

    @Override
    public ThreatVector saveThreat(ThreatVector threatVector) {

        TriggerEntity trigger = triggerRepo.findByName("policy_sum_insured");
        threatVector.setThreatVectorId(trigger.getCount() + 1);
        return threatVectorRepository.save(threatVector);
    }

    @Override
    public List<ThreatVector> getThreatList() {
        return threatVectorRepository.findAll();
    }

    @Override
    public double getTreatVector() {
        List<ThreatVector> threatList = getThreatList();
        long totalAttackCount=0;
        HashMap<ThreatVector,Long> threatAttackCount=new HashMap<>();
        for(ThreatVector threatVector: threatList){
            long attackCount = Long.valueOf(attackLibraryService.getAttackCount(threatVector.getClassificationOfActors()));
            threatAttackCount.put(threatVector,attackCount);
            totalAttackCount+=attackCount;
        }
        double sumXWA=0;
        HashMap<ThreatVector,Double> xw=new HashMap<>();
        Set<ThreatVector> threatVectors = threatAttackCount.keySet();
        Iterator<ThreatVector> iterator = threatVectors.iterator();
        while (iterator.hasNext()){
            ThreatVector threatVector = iterator.next();
            double xweight = Double.valueOf(threatAttackCount.get(threatVector));
            double xw1 = xweight * attackLibraryService.getAttackCount(threatVector.getClassificationOfActors());
            sumXWA+=xweight;
            xw.put(threatVector,xw1);
        }
        double v = sumXWA / 5;

        for(Map.Entry<ThreatVector, Long> entry : threatAttackCount.entrySet()){

        }
        return v;
    }

}
