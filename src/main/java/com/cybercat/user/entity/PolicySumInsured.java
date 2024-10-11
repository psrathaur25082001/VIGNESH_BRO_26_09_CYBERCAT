package com.cybercat.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document("policy_sum_insured")
@Data
public class PolicySumInsured  extends  EditByAndTimeStamp{
    @Id
    private int policySumInsuredId;
    private int entityId;
    private String sumInsuredAmount;


}
