package com.example.paycellwebclient.payment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil<T> {

    /**
     * Marshals Object to json
     * @param object object to be marshalled
     * @return json
     * @throws JsonProcessingException thrown if error exists during marshalling
     */
    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writer().writeValueAsString(object);
    }

    /**
     * Unmarshals json to object
     * @param json to be unmarshalled
     * @param returnClass class for the object
     * @return obbject instance
     * @throws IOException thrown if error exists during unmarshalling
     */
    public static Object convertJsonToObject(String json, Class returnClass) throws IOException {
        return new ObjectMapper().readValue(json, returnClass);
    }
}
