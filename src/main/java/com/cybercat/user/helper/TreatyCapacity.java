package com.cybercat.user.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TreatyCapacity {
    private String treatyLimit;
    private String treatLimitUtilized;
    private String treatyLimitOutStating;
    private String treatyLimitPercentage;
    private String treatyPercentageMessage;

}
