package com.example.paycellwebclient.payment.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueIdGeneratorTests {

    @Test
    public void generateUUIDshouldGenerateUniqueId(){
        Set<String> set = new HashSet<>();
        for(int i=0;i<10000;i++){
            String id = UniqueIdGenerator.generateUUID();
            Assert.assertFalse(set.contains(id));
            set.add(id);
        }
    }

    @Test
    public void generateTransactionIdShouldGenerateLengthOf20(){
        Assert.assertEquals(20, UniqueIdGenerator.generateTransactionId().length());
    }
}
