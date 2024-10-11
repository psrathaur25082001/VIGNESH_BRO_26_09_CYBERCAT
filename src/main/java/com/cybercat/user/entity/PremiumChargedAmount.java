package com.cybercat.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("premium_charged_amount")
public class PremiumChargedAmount {
    @Id
    private int premiumChargedId;
    private String premiumChargedAmount;
    private int entityId;
}
