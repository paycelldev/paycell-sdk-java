package com.example.paycellwebclient.payment.model;

public class TransactionInfo {

    /**
     * Service request date time
     * yyyyMMddHHmmssSSS format is used
     */
    private String transactionDateTime;

    /**
     * Unique id for service request
     * must consist of 20 digits
     */
    private String transactionId;

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
