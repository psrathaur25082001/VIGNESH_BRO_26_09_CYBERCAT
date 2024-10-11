package com.cybercat.user.serviceImpl;

import com.cybercat.user.entity.PremiumChargedAmount;
import com.cybercat.user.repository.PremiumChargedRepository;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.PremiumChargedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumChargedServiceImpl implements PremiumChargedService {

    @Autowired
    TriggerRepo triggerRepo;
    @Autowired
    private PremiumChargedRepository premiumChargedRepository;
    @Override
    public PremiumChargedAmount saveOrUpdatePremiumChargedAmount(PremiumChargedAmount pcAmount) {
        PremiumChargedAmount byEntityId = premiumChargedRepository.findByEntityId(pcAmount.getEntityId());
        if(byEntityId!=null){
            byEntityId.setPremiumChargedAmount(pcAmount.getPremiumChargedAmount());
            PremiumChargedAmount updatePCAmount = premiumChargedRepository.save(byEntityId);
            return updatePCAmount;
        }else {
            int count = triggerRepo.findByName("premium_charged_amount").getCount();
            pcAmount.setPremiumChargedId(count + 1);
            PremiumChargedAmount savePCAmount = premiumChargedRepository.save(pcAmount);
            return savePCAmount;
        }
    }

    @Override
    public PremiumChargedAmount getPremiumChargedAmountByEntityId(int entityId) {
        return premiumChargedRepository.findByEntityId(entityId);
    }
}
