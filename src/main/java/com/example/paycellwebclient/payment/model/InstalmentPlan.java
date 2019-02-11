package com.example.paycellwebclient.payment.model;

public class InstalmentPlan {

    /**
     * Unique in the same instalment plan list. Should be incremented by 1 starting from 1 for each row.
     */
    private String lineId;

    /**
     * Payment Method Type
     * Example: CREDIT_CARD, DCB
     */
    private String paymentMethodType;

    /**
     * Card brand partnership
     * Example: BONUS, WORLD, CARDFINANS, AXESS, ADVANTAGE, PARAF, MAXIMUM
     */
    private String cardBrand;

    /**
     * Instalment Count
     * 1 for in advance payment
     */
    private String count;

    /**
     * Represents instalment amount. Last 2 digits represents coins.
     * 1.55 is represented as "155"
     * 3.00 is represented as "300"
     */
    private String amount;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
