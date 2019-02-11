package com.example.paycellwebclient.payment.reverse;

import com.example.paycellwebclient.payment.model.RequestHeader;

public class ReverseRequest {

    /**
     * Header information of the request
     */
    private RequestHeader requestHeader;

    /**
     * paymentReferenceNumber of the Payment
     */
    private String originalReferenceNumber;

    /**
     * Unique reference number of the operation, first 3 digit is application specific and defined by Paycell Web SDK
     */
    private String referenceNumber;

    /**
     * Merchant code, defined by Paycell Web SDK for each merchant
     */
    private String merchantCode;

    /**
     * Phone number of the customer
     * country code must be added
     */
    private String msisdn;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getOriginalReferenceNumber() {
        return originalReferenceNumber;
    }

    public void setOriginalReferenceNumber(String originalReferenceNumber) {
        this.originalReferenceNumber = originalReferenceNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
