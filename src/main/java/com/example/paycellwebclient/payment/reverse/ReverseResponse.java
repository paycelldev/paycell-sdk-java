package com.example.paycellwebclient.payment.reverse;

import com.example.paycellwebclient.payment.model.ResponseHeader;

public class ReverseResponse {

    /**
     * Header information of the response
     */
    private ResponseHeader responseHeader;

    /**
     * Approval code information
     */
    private String approvalCode;

    /**
     * Status code of the retry
     */
    private String retryStatusCode;

    /**
     * Description of the retry status
     */
    private String retryStatusDescription;

    /**
     * reconciliation date information
     * Format used: YYYYMMDD
     */
    private String reconciliationDate;

    public String getRetryStatusDescription() {
        return retryStatusDescription;
    }

    public void setRetryStatusDescription(String retryStatusDescription) {
        this.retryStatusDescription = retryStatusDescription;
    }

    public String getRetryStatusCode() {
        return retryStatusCode;
    }

    public void setRetryStatusCode(String retryStatusCode) {
        this.retryStatusCode = retryStatusCode;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(String reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }
}
