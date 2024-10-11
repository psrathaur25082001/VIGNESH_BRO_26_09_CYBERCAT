package com.cybercat.user.helper;

public class CalculationHelper {

    public static double calculateLn(double x) {
        if (x > 0) {
            return Math.log(x); // Math.log() in Java returns the natural logarithm
        } else {
            throw new IllegalArgumentException("ln(x) is undefined for non-positive x.");
        }
    }

}
