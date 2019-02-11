package com.example.paycellwebclient.payment.util;

import java.util.UUID;

public class UniqueIdGenerator {

    private static int sequence = 1;

    /**
     * generates random id
     * @return generated id
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * Generates 20 digist ID from sequence
     * @return generated id
     */
    public static String generateTransactionId(){
        return String.format("%020d", sequence++);
    }
}
