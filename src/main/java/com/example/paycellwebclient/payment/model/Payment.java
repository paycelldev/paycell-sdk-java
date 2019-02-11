package com.example.paycellwebclient.payment.model;

import java.util.List;

public class Payment {

    /**
     * Represents total payment amount in advance. If different amounts will be given for different payment methods,
     * They should be added in instalmentPlans. Count attribute for instalment plans that will be paid in advance should
     * be given as 1. Last 2 decimal represents coins.
     * 1.55 is represented as "155"
     * 3.00 is represented as "300"
     */
    private String amount;

    /**
     * Currency
     * TL is represented as "99"
     */
    private String currency;

    /**
     * Unique id for payment request, Merchant provides this information
     */
    private String paymentReferenceNumber;

    /**
     * Defines how security will be provided for credit card payments
     */
    private String paymentSecurity;

    /**
     * List of instalment plans
     */
    private List<InstalmentPlan> instalmentPlan;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

    public String getPaymentSecurity() {
        return paymentSecurity;
    }

    public void setPaymentSecurity(String paymentSecurity) {
        this.paymentSecurity = paymentSecurity;
    }

    public List<InstalmentPlan> getInstalmentPlan() {
        return instalmentPlan;
    }

    public void setInstalmentPlan(List<InstalmentPlan> instalmentPlan) {
        this.instalmentPlan = instalmentPlan;
    }

}
