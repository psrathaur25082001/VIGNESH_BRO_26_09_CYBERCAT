package com.cybercat.user.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class ClientInfoDto {

    private String clientId;
    private String industryId;
    private String industryName;
    private String region;
    private long revenue;
    private Double startingRange;
    private Double endingRange;

}
