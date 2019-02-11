package com.example.paycellwebclient.payment.util;

import com.example.paycellwebclient.payment.model.InstalmentPlan;
import com.example.paycellwebclient.payment.model.Merchant;
import com.example.paycellwebclient.payment.model.Payment;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class HashFactory {

    /**
     * Security Data : Sha256(SecureCode + TerminalCode)
     * Merchant Hash Data : Sha256(paymentReferenceNumber + terminalCode + amount + currency + paymentSecurity +
     *  hostAccount + installmentPlan (lineId sırası ile taksit bilgileri birleştirilir --> lineId + paymentMethodType +
     *  cardBrand + count + amount) + SecurityData)

     */
    public static String createHash(Merchant merchant, Payment payment, String hostAccount) {
        String securityData = sha256(PaycelWebConstants.SECURE_CODE+merchant.getTerminalCode());
        StringBuilder sb = new StringBuilder();
        sb.append(payment.getPaymentReferenceNumber());
        sb.append(merchant.getTerminalCode());
        sb.append(payment.getAmount());
        sb.append(payment.getCurrency());
        sb.append(payment.getPaymentSecurity());
        sb.append(hostAccount);
        /*
        for(InstalmentPlan instalmentPlan : sortByLineId(payment.getInstalmentPlan())){
            sb.append(instalmentPlan.getLineId());
            sb.append(instalmentPlan.getPaymentMethodType().toString());
            sb.append(instalmentPlan.getCardBrand().toString());
            sb.append(instalmentPlan.getCount());
            sb.append(instalmentPlan.getAmount());
        }*/
        sb.append(securityData);
        return sha256(sb.toString());
    }

    /**
     * Sorts list by line id asc
     * @param instalmentPlans a list of {@link InstalmentPlan}
     * @return sorted list
     */
    static List<InstalmentPlan> sortByLineId(List<InstalmentPlan> instalmentPlans) {
        instalmentPlans.sort((o1, o2) -> Integer.valueOf(o1.getLineId()) - Integer.valueOf(o2.getLineId()));
        return instalmentPlans;
    }

    /**
     * Encode string with sha256 and represented in Base64
     * @param originalString text to be encoded
     * @return encoded text
     */
    static String sha256(String originalString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
