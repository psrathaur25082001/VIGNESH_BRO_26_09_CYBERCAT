package com.cybercat.user.service;

import com.cybercat.user.entity.PremiumChargedAmount;

public interface PremiumChargedService {

    PremiumChargedAmount saveOrUpdatePremiumChargedAmount(PremiumChargedAmount pcAmount);
    PremiumChargedAmount getPremiumChargedAmountByEntityId(int entityId);
}
