package com.cybercat.user.config;

import java.util.Map;

public class IndustryConfig {
    private static final Map<String, Map<String, Double[]>> industryPercentages = Map.of(
            "Technology", Map.of(
                    "0-1000000000", new Double[]{2.95, 24.00},
                    "1000000000-5000000000", new Double[]{1.02, 4.55},
                    "5000000000-10000000000", new Double[]{1.15, 5.65},
                    "10000000000-25000000000", new Double[]{1.28, 5.80},
                    "25000000000-50000000000", new Double[]{1.41, 5.95},
                    "50000000000-100000000000", new Double[]{1.54, 5.10},
                    ">100000000000", new Double[]{1.65, 5.25}
            ),
            "Pharmaceuticals", Map.of(
                    "0-1000000000", new Double[]{2.15, 20.00},
                    "1000000000-5000000000", new Double[]{1.02, 4.52},
                    "5000000000-10000000000", new Double[]{1.15, 4.65},
                    "10000000000-25000000000", new Double[]{1.28, 4.80},
                    "25000000000-50000000000", new Double[]{1.41, 4.95},
                    "50000000000-100000000000", new Double[]{1.54, 5.10},
                    ">100000000000", new Double[]{1.65, 5.25}
            ),
             "BFSI" ,Map.of(
                    "0-1000000000", new Double[]{3.15, 22.50},
                    "1000000000-5000000000", new Double[]{1.05, 4.75},
                    "5000000000-10000000000", new Double[]{1.15, 5.05},
                    "10000000000-25000000000", new Double[]{1.35, 5.35},
                    "25000000000-50000000000", new Double[]{1.50, 5.65},
                    "50000000000-100000000000", new Double[]{1.65, 5.95},
                    ">100000000000", new Double[]{1.85, 6.25}
            ),
            "OilAndGas",Map.of(
                    "0-1000000000", new Double[]{3.15, 22.50},
                    "1000000000-5000000000", new Double[]{1.02, 4.35},
                    "5000000000-10000000000", new Double[]{1.15, 5.05},
                    "10000000000-25000000000", new Double[]{1.28, 5.55},
                    "25000000000-50000000000", new Double[]{1.41, 5.75},
                    "50000000000-100000000000", new Double[]{1.54, 5.95},
                    ">100000000000", new Double[]{1.65, 6.15}
            ),
            "Manufacturing",Map.of(
                    "0-1000000000", new Double[]{3.15, 22.50},
                    "1000000000-5000000000", new Double[]{1.02, 4.75},
                    "5000000000-10000000000", new Double[]{1.15, 5.05},
                    "10000000000-25000000000", new Double[]{1.28, 5.35},
                    "25000000000-50000000000", new Double[]{1.41, 5.65},
                    "50000000000-100000000000", new Double[]{1.54, 5.95},
                    ">100000000000", new Double[]{1.65, 6.25}
            ),
           "Others" ,Map.of(
                    "0-1000000000", new Double[]{3.15, 22.50},
                    "1000000000-5000000000", new Double[]{1.02, 4.75},
                    "5000000000-10000000000", new Double[]{1.15, 5.05},
                    "10000000000-25000000000", new Double[]{1.28, 5.35},
                    "25000000000-50000000000", new Double[]{1.41, 5.65},
                    "50000000000-100000000000", new Double[]{1.54, 5.95},
                    ">100000000000", new Double[]{1.65, 6.25}
            )

    );

    public static Double[] getPercentages(String industryName, String revenueRange) {
        return industryPercentages.getOrDefault(industryName, Map.of())
                .getOrDefault(revenueRange, new Double[]{0.0, 0.0});
    }
}

