package com.example.paycellwebclient.payment.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtil {

    /**
     * InputStream is read into string UTF-8 encoded
     * @param inputStream to be read
     * @return String created
     */
    public static String readInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (Exception e) {
            return null;
        }
    }
}
