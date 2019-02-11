package com.example.paycellwebclient.payment.model;

import java.util.List;

public class Merchant {

    /**
     * Merchant code, defined by Paycell Web SDK for each Merchant
     */
    private String merchantCode;

    /**
     * Terminal code, defined by Paycell Web SDK for each Merchant
     */
    private String terminalCode;

    /**
     * List of logo urls
     */
    private List<String> logos;

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public List<String> getLogos() {
        return logos;
    }

    public void setLogos(List<String> logos) {
        this.logos = logos;
    }
}
