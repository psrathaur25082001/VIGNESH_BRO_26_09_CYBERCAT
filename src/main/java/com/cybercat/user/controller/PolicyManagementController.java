package com.cybercat.user.controller;

import com.cybercat.user.entity.EntityList;
import com.cybercat.user.entity.PolicySumInsured;
import com.cybercat.user.entity.PremiumChargedAmount;
import com.cybercat.user.entity.ThreatVector;
import com.cybercat.user.helper.TreatyCapacity;
import com.cybercat.user.payload.PolicyTreatyPercentageDto;
import com.cybercat.user.service.EntityService;
import com.cybercat.user.service.PolicySumInsuredService;
import com.cybercat.user.service.PremiumChargedService;
import com.cybercat.user.service.ThreatVectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
@Slf4j
@Tag(name = "Policy Controller", description = "Policy Related Api Below")
public class PolicyManagementController {
    @Autowired
    private EntityService entityService;
    @Autowired
    private PolicySumInsuredService policySumInsuredService;
    @Autowired
    private PremiumChargedService premiumChargedService;
    @Autowired
    private ThreatVectorService threatVectorService;

    @PostMapping("/saveOrUpdateSumInsuredAmount")
    @Operation(summary = "saveOrUpdateSumInsuredAmount", description = "sum Insured amount saved in db")
    public ResponseEntity<PolicySumInsured> saveOrUpdateSumInsuredAmount(@RequestBody PolicySumInsured policySumInsured){
        PolicySumInsured policySumInsured1 = policySumInsuredService.saveOrUpdatePolicySumInsured(policySumInsured);
        return ResponseEntity.status(HttpStatus.CREATED).body(policySumInsured1);
    }
    @PostMapping("/getPolicySumInsuredAmount/{entityId}")
    public ResponseEntity<PolicySumInsured> getSumInsuredAmountByEntityId(@PathVariable("entityId")int entityId){
        PolicySumInsured policySumInsured1 = policySumInsuredService.getPolicySumInsuredByEntityId(entityId);
        return ResponseEntity.status(HttpStatus.OK).body(policySumInsured1);
    }

    @PostMapping("/getTreatyByEntityId/{entityId}")
    public ResponseEntity<TreatyCapacity> getTreatyCapacityByEntityId(@PathVariable("entityId")int entityId){
        TreatyCapacity treatyCapacity = entityService.getTreatyByEntityId(entityId);
        return ResponseEntity.status(HttpStatus.OK).body(treatyCapacity);
    }

    @PostMapping("/updatePolicy")
    public ResponseEntity<EntityList> updateTreatyPercentage(@RequestBody PolicyTreatyPercentageDto dto){
        EntityList entityList = entityService.updatePolicyTreatyPercentage(dto);
        return ResponseEntity.status(HttpStatus.OK).body(entityList);
    }

    @PostMapping("/saveOrUpdatePremiumChargedAmount")
    public ResponseEntity<PremiumChargedAmount> saveOrUpdatePremiumChargedAmount(@RequestBody PremiumChargedAmount pcAmount){
        PremiumChargedAmount premiumChargedAmount = premiumChargedService.saveOrUpdatePremiumChargedAmount(pcAmount);
        return ResponseEntity.status(HttpStatus.CREATED).body(premiumChargedAmount);
    }
    @GetMapping("/getChargedPremiumAmount/{entityId}")
    public ResponseEntity<PremiumChargedAmount> getPremiumChargedAmountByEntityId(@PathVariable("entityId")int entityId){
        return ResponseEntity.status(HttpStatus.OK).body(premiumChargedService.getPremiumChargedAmountByEntityId(entityId));
    }

    @GetMapping("/getSolvencyRisk/{entityId}")
    public ResponseEntity getSolvencyRisk(@PathVariable("entityId")int entityId){
        return ResponseEntity.status(HttpStatus.OK).body(entityService.calculateSolvencyRisk(entityId));

    }

    @PostMapping("/saveThreatVector")
    public ResponseEntity<ThreatVector> saveThreatVector(@RequestBody ThreatVector threatVector){
        return  ResponseEntity.status(HttpStatus.CREATED).body(threatVectorService.saveThreat(threatVector));
    }
    @GetMapping("/getThreatVectorList")
    public ResponseEntity<List<ThreatVector>> getThreatVectorList(){
        return  ResponseEntity.status(HttpStatus.OK).body(threatVectorService.getThreatList());
    }


}
