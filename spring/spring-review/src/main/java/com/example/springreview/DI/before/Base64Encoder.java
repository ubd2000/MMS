package com.example.springreview.DI.before;

import java.util.Base64;

/**
 * @author ubd2000
 */
public class Base64Encoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
