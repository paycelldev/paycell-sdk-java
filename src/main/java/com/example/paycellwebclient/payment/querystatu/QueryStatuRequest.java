package com.example.paycellwebclient.payment.querystatu;

import com.example.paycellwebclient.payment.model.RequestHeader;

public class QueryStatuRequest {

    /**
     * Original payment reference number: Generated by merchant during init phase
     */
    private String originalPaymentReferenceNumber;

    /**
     * Merchant code: Defined by Paycell Web SDK for each Merchant
     */
    private String merchantCode;

    /**
     * Request Header information
     */
    private RequestHeader requestHeader;

    public String getOriginalPaymentReferenceNumber() {
        return originalPaymentReferenceNumber;
    }

    public void setOriginalPaymentReferenceNumber(String originalPaymentReferenceNumber) {
        this.originalPaymentReferenceNumber = originalPaymentReferenceNumber;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }
}
