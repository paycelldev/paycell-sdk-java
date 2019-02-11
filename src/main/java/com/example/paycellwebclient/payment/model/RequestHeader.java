package com.example.paycellwebclient.payment.model;

public class RequestHeader {

    /**
     * Unique id of the transaction
     */
    private String transactionId;

    /**
     * Format used: YYYYMMddHHmmssSSS
     */
    private String transactionDateTime;

    /**
     * IP address of the requester
     */
    private String clientIPAddress;

    /**
     * Application name: defined by Paycell Web SDK for each merchant
     */
    private String applicationName;

    /**
     * Application password: defined by Paycell Web SDK for each merchant
     */
    private String applicationPwd;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getClientIPAddress() {
        return clientIPAddress;
    }

    public void setClientIPAddress(String clientIPAddress) {
        this.clientIPAddress = clientIPAddress;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationPwd() {
        return applicationPwd;
    }

    public void setApplicationPwd(String applicationPwd) {
        this.applicationPwd = applicationPwd;
    }
}
