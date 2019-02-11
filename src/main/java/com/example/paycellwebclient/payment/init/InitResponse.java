package com.example.paycellwebclient.payment.init;

public class InitResponse {

    /**
     * Tracking information, is used for accessing to the payment screen of Paycell Web SDK
     */
    private String trackingId;

    /**
     * Status code of the request, is "0" if the operation was successful.
     */
    private String statusCode;

    /**
     * Status message of the request, is "Success" if the operation was successful.
     */
    private String message;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
