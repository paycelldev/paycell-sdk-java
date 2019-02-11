package com.example.paycellwebclient.payment.ui.model.viewdto;

public class QueryStatuViewDto {

    private String msisdn;
    private String amount;
    private String currency;
    private String installmentCount;
    private String paymentSecurity;
    private String paymentDate;
    private String reconcilationDate;
    private String acquirerbankCode;
    private String issuerBankCode;
    private String approvalCode;
    private String orderId;
    private String paymentReferenceNumber;
    private String extraParameters;
    private String status;
    private String statusExplanation;
    private String paymentMethodId;
    private String paymentMethodNumber;
    private String paymentMethodType;

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
