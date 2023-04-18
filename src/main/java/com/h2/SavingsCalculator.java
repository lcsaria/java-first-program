package com.h2;

import java.time.LocalDate;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public float calculate() {
        float creditsTotal = 0;
        for(float credit : credits) {
            creditsTotal += credit;
        }

        float debitsTotal = 0;
        for(float debit : debits) {
            debitsTotal += debit;
        }

        return creditsTotal - debitsTotal;
    }

    public static int remainingDaysInMonth(LocalDate date) {
        return date.lengthOfMonth() - date.getDayOfMonth();
    }

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        float[] credits = new float[creditsAsString.length];
        for(int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        float[] debits = new float[debitsAsString.length];
        for(int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
