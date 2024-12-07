package com.cybercat.user.serviceImpl;

import com.cybercat.user.entity.PolicySumInsured;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.repository.PolicySumInsuredRepository;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.PolicySumInsuredService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Slf4j
public class PolicySumInsuredServiceImpl implements PolicySumInsuredService {
    @Autowired
    TriggerRepo triggerRepo;
    @Autowired
    private PolicySumInsuredRepository policySumInsuredRepo;

    @Override
    public PolicySumInsured saveOrUpdatePolicySumInsured(PolicySumInsured policySumInsured) {
       PolicySumInsured policySumInsured1 = policySumInsuredRepo.findByEntityId(policySumInsured.getEntityId());
        if(policySumInsured1!=null){
            policySumInsured1.setSumInsuredAmount(policySumInsured.getSumInsuredAmount());
            policySumInsured1.setModifyBy(policySumInsured.getModifyBy());
            policySumInsured1.setModifyDate(policySumInsured.getModifyDate());
            PolicySumInsured updatePolicySumInsured = policySumInsuredRepo.save(policySumInsured1);
            return updatePolicySumInsured;
        }
        else {
            TriggerEntity trigger = triggerRepo.findByName("policy_sum_insured");
            policySumInsured.setPolicySumInsuredId(trigger.getCount() + 1);
            PolicySumInsured savePolicySumInsuredAmount = policySumInsuredRepo.save(policySumInsured);
            return savePolicySumInsuredAmount;
        }

    }

    @Override
    public PolicySumInsured getPolicySumInsuredByEntityId(int entityId) {
        PolicySumInsured policySumInsured = policySumInsuredRepo.findByEntityId(entityId);
        return policySumInsured;
    }

    @Override
    public double getIRate(double infectionRate, double threatVectorRate) {
        return 0;
    }
}
