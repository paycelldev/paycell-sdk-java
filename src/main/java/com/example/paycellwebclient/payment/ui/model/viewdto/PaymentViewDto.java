package com.example.paycellwebclient.payment.ui.model.viewdto;

import java.util.ArrayList;
import java.util.List;

public class PaymentViewDto {

    private String paymentReferenceNumber;

    private String amount;

    private String currency;

    private String paymentSecurity;

    private List<InstalmentPlanViewDto> instalmentPlans;

    public PaymentViewDto() {
        instalmentPlans = new ArrayList<>();
    }

    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

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

    public String getPaymentSecurity() {
        return paymentSecurity;
    }

    public void setPaymentSecurity(String paymentSecurity) {
        this.paymentSecurity = paymentSecurity;
    }

    public List<InstalmentPlanViewDto> getInstalmentPlans() {
        return instalmentPlans;
    }

    public void setInstalmentPlans(List<InstalmentPlanViewDto> instalmentPlans) {
        this.instalmentPlans = instalmentPlans;
    }
}
