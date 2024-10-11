package com.cybercat.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@Document("t_Ransomeware")
public class ClientInfo{
    @Id
    private String clientId;
    private String industryId;
    private String region;
    private String industryName;
    private long revenue;
    private Double startingRange;
    private Double endingRange;
}
