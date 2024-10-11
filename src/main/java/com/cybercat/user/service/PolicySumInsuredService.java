package com.cybercat.user.service;

import com.cybercat.user.entity.PolicySumInsured;

public interface PolicySumInsuredService {

    PolicySumInsured saveOrUpdatePolicySumInsured(PolicySumInsured policySumInsured);
    PolicySumInsured getPolicySumInsuredByEntityId(int entityId);

}
