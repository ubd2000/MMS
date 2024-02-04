package com.example.springreview.DI.abstract_the_encoder;

import java.util.Base64;

/**
 * @author ubd2000
 */
public class Encoder {

    private IEncoder iEncoder;

    public Encoder() {
//        this.iEncoder = new UrlEncoder();
        this.iEncoder = new Base64Encoder();
    }

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
