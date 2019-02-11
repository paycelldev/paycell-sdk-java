package com.example.paycellwebclient.payment.querystatu;

import com.example.paycellwebclient.payment.model.ResponseHeader;

public class QueryStatuResponse {

    /**
     * Header information of the response
     */
    private ResponseHeader responseHeader;

    /**
     * Extra parameters
     */
    private String extraParameters;

    /**
     * Acquirer bank code information is returned,
     * exists for Paycell Card and Credit Card payments
     */
    private String acquirerbankCode;

    /**
     * Phone number of the customer
     */
    private String msisdn;

    /**
     * Total amount of the payment
     */
    private String amount;

    /**
     * Approval code information
     */
    private String approvalCode;

    /**
     * Currency information,
     * 99 for TL
     */
    private String currency;

    /**
     * Instalment count, "1" for in advance payment
     */
    private String installmentCount;

    /**
     * Order ID information
     */
    private String orderId;

    /**
     * Security method used for payment
     * - THREED_SECIRE
     * - NON_THREED_SECURE
     */
    private String paymentSecurity;

    /**
     * Date of the payment is taken
     */
    private String paymentDate;

    /**
     * Reconcilation date of the payment
     */
    private String reconcilationDate;

    /**
     * Unique id of the payment, generated by merchant
     */
    private String paymentReferenceNumber;

    /**
     * Issuer Bank Code information,
     * exists for paycell card and credit card payments.
     */
    private String issuerBankCode;

    /**
     * Status of the payment
     * - 0: Payment is successful
     * - 1: Payment is reversed
     * - 2: Payment is refunded
     * - 3: Payment is not found
     * - 4: Payment is pending
     * - 5: Unknown response
     * - 6: Error or Timeout occurred
     */
    private String status;

    /**
     * Status detail is given
     */
    private String statusExplanation;

    /**
     * Payment method used for the payment
     */
    private PaymentMethod paymentMethod;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getExtraParameters() {
        return extraParameters;
    }

    public void setExtraParameters(String extraParameters) {
        this.extraParameters = extraParameters;
    }

    public String getAcquirerbankCode() {
        return acquirerbankCode;
    }

    public void setAcquirerbankCode(String acquirerbankCode) {
        this.acquirerbankCode = acquirerbankCode;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(String installmentCount) {
        this.installmentCount = installmentCount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentSecurity() {
        return paymentSecurity;
    }

    public void setPaymentSecurity(String paymentSecurity) {
        this.paymentSecurity = paymentSecurity;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getReconcilationDate() {
        return reconcilationDate;
    }

    public void setReconcilationDate(String reconcilationDate) {
        this.reconcilationDate = reconcilationDate;
    }

    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

    public String getIssuerBankCode() {
        return issuerBankCode;
    }

    public void setIssuerBankCode(String issuerBankCode) {
        this.issuerBankCode = issuerBankCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusExplanation() {
        return statusExplanation;
    }

    public void setStatusExplanation(String statusExplanation) {
        this.statusExplanation = statusExplanation;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}