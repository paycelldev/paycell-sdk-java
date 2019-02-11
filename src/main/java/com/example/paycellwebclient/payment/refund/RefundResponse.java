package com.example.paycellwebclient.payment.refund;

import com.example.paycellwebclient.payment.model.ResponseHeader;

public class RefundResponse {

    /**
     * Header information
     */
    private ResponseHeader responseHeader;

    /**
     * Reconciliation date information,
     * format used: yyyyMMdd
     */
    private String reconciliationDate;

    /**
     * Approval code information
     */
    private String approvalCode;

    /**
     * Status code of retry
     */
    private String retryStatusCode;

    /**
     * Description of retry status
     */
    private String retryStatusDescription;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(String reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getRetryStatusCode() {
        return retryStatusCode;
    }

    public void setRetryStatusCode(String retryStatusCode) {
        this.retryStatusCode = retryStatusCode;
    }

    public String getRetryStatusDescription() {
        return retryStatusDescription;
    }

    public void setRetryStatusDescription(String retryStatusDescription) {
        this.retryStatusDescription = retryStatusDescription;
    }
}
