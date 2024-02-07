package com.example.springreview;

import com.example.springreview.Ioc.ApplicationContextProvider;
import com.example.springreview.Ioc.Base64Encoder;
import com.example.springreview.Ioc.Encoder;
import com.example.springreview.Ioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReviewApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("base64Encode", Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);
    }
}


@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder2(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
