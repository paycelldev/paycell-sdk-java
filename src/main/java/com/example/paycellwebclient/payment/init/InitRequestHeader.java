package com.example.paycellwebclient.payment.init;

import com.example.paycellwebclient.payment.model.Merchant;
import com.example.paycellwebclient.payment.model.TransactionInfo;

public class InitRequestHeader {

    /**
     * Merchant information
     */
    private Merchant merchant;

    /**
     * Transaction information
     */
    private TransactionInfo transactionInfo;

    /**
     * Merchant Application name, defined by Paycell Web SDK for each Merchant
     */
    private String applicationName;

    /**
     * Merchant Application password, defined by Paycell Web SDK for each Merchant
     */
    private String applicationPassword;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationPassword() {
        return applicationPassword;
    }

    public void setApplicationPassword(String applicationPassword) {
        this.applicationPassword = applicationPassword;
    }

}
