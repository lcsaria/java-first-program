package com.h2;

import com.h2.Utilities;

public class MortgageCalculator {

    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
        monthlyPayment = M;
    }

    @Override
    public String toString() {
        return String.format("monthlyPayment: %.2f" , monthlyPayment);
    }

    public static void main(String[] args) {
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        // Create new MortgageCalculator instance
        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);

        // Calculate monthly payment
        calculator.calculateMonthlyPayment();

        // Print monthly payment
        System.out.println(calculator.toString());
    }
}
