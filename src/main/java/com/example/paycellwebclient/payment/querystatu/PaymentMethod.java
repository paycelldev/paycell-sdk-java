package com.example.paycellwebclient.payment.querystatu;

public class PaymentMethod {

    /**
     * Unique id of the payment method used
     */
    private String paymentMethodId;

    /**
     * Masked credit card number
     * Retrieved from CCPO Service
     */
    private String paymentMethodNumber;

    /**
     * Type of payment method:
     * - CREDITCARD: for credit card
     * - PCARD: for paycell card
     */
    private String paymentMethodType;

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodNumber() {
        return paymentMethodNumber;
    }

    public void setPaymentMethodNumber(String paymentMethodNumber) {
        this.paymentMethodNumber = paymentMethodNumber;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }
}
