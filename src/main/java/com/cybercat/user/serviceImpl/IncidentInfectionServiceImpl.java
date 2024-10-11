package com.cybercat.user.serviceImpl;

import com.cybercat.user.entity.IncidentInfection;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.repository.IncidentInfectionRepository;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.IncidentInfectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncidentInfectionServiceImpl implements IncidentInfectionService {
    @Autowired
    private IncidentInfectionRepository incidentInfectionRepository;
    @Autowired
    TriggerRepo triggerRepo;

    @Override
    public IncidentInfection saveIncidentInfection(IncidentInfection incidentInfection) {
        TriggerEntity trigger = triggerRepo.findByName("t_incident_infection");
        incidentInfection.setIncidentInfectionId(trigger.getCount() + 1);
        return incidentInfectionRepository.save(incidentInfection);
    }

    @Override
    public List<IncidentInfection> findByIndustryTypeList(String industryType) {
        return incidentInfectionRepository.findByIndustryType(industryType);
    }

    @Override
    public double infectionRate(String industryType) {

        List<IncidentInfection> list = incidentInfectionRepository.findByIndustryType(industryType);
        double totalIncidentCount=0;
        for (IncidentInfection i:list){
            totalIncidentCount+=Double.valueOf(i.getIncidentCount());
        }
        Map<IncidentInfection,Double> divisibleByTotalIncident=new HashMap<>();
        for(IncidentInfection i:list){
            double d= Double.valueOf(i.getIncidentCount()) / totalIncidentCount;
            divisibleByTotalIncident.put(i,d);
        }
        double sumDivisibleWithoutDays = divisibleByTotalIncident.values()
                .stream()
                .mapToDouble(Number::doubleValue)  // Assuming values are Number type
                .sum();

        Set<IncidentInfection> incidentInfections = divisibleByTotalIncident.keySet();
        Iterator<IncidentInfection> iterator = incidentInfections.iterator();
        Map<IncidentInfection,Double> divisibleByTotalIncidentWithDays=new HashMap<IncidentInfection,Double> ();
        while (iterator.hasNext()){
            IncidentInfection next = iterator.next();
            Double value = divisibleByTotalIncident.get(next);
            divisibleByTotalIncidentWithDays.put(next,value/Double.valueOf( next.getDays()));
        }

        Set<IncidentInfection> incidentInfections1 = divisibleByTotalIncidentWithDays.keySet();
        Iterator<IncidentInfection> itr = incidentInfections1.iterator();
        Map<IncidentInfection,Double> checkLowHigh=new HashMap<IncidentInfection,Double> ();
        while (itr.hasNext()){
            IncidentInfection infection = itr.next();
            if (infection.getIncidentCriticality().equalsIgnoreCase("low")){
                checkLowHigh.put(infection, Math.pow(divisibleByTotalIncidentWithDays.get(infection),2));
            }else if (infection.getIncidentCriticality().equalsIgnoreCase("high")){
                checkLowHigh.put(infection, Math.sqrt(divisibleByTotalIncidentWithDays.get(infection)));
            }else {
                checkLowHigh.put(infection,divisibleByTotalIncidentWithDays.get(infection));
            }

        }
        double infectionRate = checkLowHigh.values()
                .stream()
                .mapToDouble(Number::doubleValue)  // Assuming values are Number type
                .sum();
        return infectionRate;
    }
}
