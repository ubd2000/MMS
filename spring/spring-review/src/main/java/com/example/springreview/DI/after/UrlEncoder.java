package com.example.springreview.DI.after;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ubd2000
 */
public class UrlEncoder implements IEncoder {

    public String encode(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
