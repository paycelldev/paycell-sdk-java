package com.example.paycellwebclient.payment.validationtracking;

import com.example.paycellwebclient.payment.init.InitRestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationTrackingController {

    /**
     * Handles returned data after payment
     * Url is binded to postResultUrl in {@link InitRestClient}
     * @param paymentNotification data to be handled
     * @return Success if handled successfully
     */
    @PostMapping("/handlePostResult")
    public ResponseEntity<String> handlePostResult(@RequestBody PaymentNotification paymentNotification){
        if(paymentNotification.getIsTimeoutOperation()){
            handleTimeout(paymentNotification);
        } else if(paymentNotification.getIsCancelled()){
            handleCancel(paymentNotification);
        } else if(paymentNotification.getIsPaid()){
            handlePaid(paymentNotification);
        }
        return ResponseEntity.ok("Success");
    }

    /**
     * Handles if the payment is paid
     * @param paymentNotification
     */
    void handlePaid(PaymentNotification paymentNotification) {
    }

    /**
     * Handles if the payment is cancelled
     * @param paymentNotification
     */
    void handleCancel(PaymentNotification paymentNotification) {
    }

    /**
     * Handles if the payment had timeout
     * @param paymentNotification
     */
    void handleTimeout(PaymentNotification paymentNotification) {
        if(paymentNotification.getIsReverse()){
            reversePayment(paymentNotification);
        }
    }

    /**
     * Handles if payment has to be reversed
     * @param paymentNotification
     */
    void reversePayment(PaymentNotification paymentNotification) {
    }

}
