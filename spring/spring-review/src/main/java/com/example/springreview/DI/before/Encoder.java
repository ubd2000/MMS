package com.example.springreview.DI.before;

import java.util.Base64;

/**
 * @author ubd2000
 */
public class Encoder {

    private Base64Encoder base64Encoder;
//    private UrlEncoder urlEncoder;

    public Encoder() {
        this.base64Encoder = new Base64Encoder();
//        this.urlEncoder = new UrlEncoder();
    }

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
