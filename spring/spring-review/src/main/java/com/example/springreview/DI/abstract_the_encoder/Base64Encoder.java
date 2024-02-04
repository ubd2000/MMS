package com.example.springreview.DI.abstract_the_encoder;

import java.util.Base64;

/**
 * @author ubd2000
 */
public class Base64Encoder implements IEncoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
