package com.example.paycellwebclient.payment.validationtracking;

public class PaymentNotification {

    /**
     * Tracking information
     */
    private String trackingId;

    /**
     * Payment method type is returned
     * - CREDIT_CARD: for credit cards
     * - PCARD: for paycell cards
     * - DCB: for mobile payments
     * - EPARA: for Dijital Para payments.
     */
    private String paymentMethodType;

    /**
     * Unique id for payment, Information is provided by merchant
     */
    private String paymentReferenceNumber;

    /**
     * Represents if the payment is paid. Payment may be in timeout. isReverse should be checked also.
     * An action should be taken by merchant if isReverse flag active.
     */
    private Boolean isPaid;

    /**
     * Represents if the payment is taken beside the payment had a timeout.
     * An action should be taken by merchant.
     */
    private Boolean isReverse;

    /**
     * Represents transaction date
     */
    private String transactionDate;

    /**
     * Total amount of payment in advance. last two digist represents coins.
     * 1.66 is represented as 166
     * 1.00 is represented as 100
     */
    private String amount;

    /**
     * Represents if the merchant card time limit is exceeded
     */
    private Boolean isTimeoutOperation;

    /**
     * Represents if the customer cancelled the operation
     */
    private Boolean isCancelled;

    /**
     * Unique id of the transaction
     */
    private String transactionId;

    /**
     * datetime of the transaction
     */
    private String transactionDateTime;

    /**
     * IP Address of the requester
     */
    private String clientIPAddress;

    /**
     * Application name, defined by Turkcell Web SDK for each merchant
     */
    private String applicationName;

    /**
     * Application password, defined by Turkcell Web SDK for each merchant
     */
    private String applicationPwd;

    /**
     * Merchant Code, defined by Turkcell Web SDK for each merchant
     */
    private String merchantCode;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Boolean getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(Boolean isReverse) {
        this.isReverse = isReverse;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getIsTimeoutOperation() {
        return isTimeoutOperation;
    }

    public void setIsTimeoutOperation(Boolean isTimeoutOperation) {
        this.isTimeoutOperation = isTimeoutOperation;
    }

    public Boolean getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

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

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
