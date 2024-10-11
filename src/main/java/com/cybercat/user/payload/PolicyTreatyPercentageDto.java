package com.cybercat.user.payload;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyTreatyPercentageDto {
    private int entityId;
    private String ACQCost	;
    private String OBLIGATORYTOGIC	;
    private String NetRetention	;
    private String QST;
    private String CEDANTCommission;

}
