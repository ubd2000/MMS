package com.example.springreview.DI.after;

import java.util.Base64;

/**
 * @author ubd2000
 */
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
