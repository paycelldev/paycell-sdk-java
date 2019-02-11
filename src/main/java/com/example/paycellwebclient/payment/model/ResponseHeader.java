package com.example.paycellwebclient.payment.model;

public class ResponseHeader {

    /**
     * Unique id of the transaction
     * Must consist of 20 digits
     */
    private String transactionId;

    /**
     * Date time of the response
     * Format used: YYYYMMddHHmmssSSS
     */
    private String responseDateTime;

    /**
     * Result code of the response
     * "0" if it is success
     */
    private String responseCode;

    /**
     * Description of the response code
     */
    private String responseDescription;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }
}
