package com.example.springreview;

import com.example.springreview.DI.after.UrlEncoder;
import com.example.springreview.DI.before.Encoder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringReviewApplicationTests {

    @Test
    void objectMapperTest() throws JsonProcessingException {

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // rsponse object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object -> text 변환 할 시 get Method(User class의 getMethod)를 활용
        // get Method를 활용하기 때무에 objectMapper class가 참조하는 class는 getMethod를 사용함에 있어 주의하자
        var user = new User("steve", 10, "010-1111-1111");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // text -> object 변환 할 시 default 생성자를 활용
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

    /**
     * DI를 알기전에 Dependency 의존관계에 대해 알아야한다.
     * Dependency 의존관계란 무엇인가?
     * “A가 B를 의존한다.”는 표현은 어떤 의미일까? 추상적인 표현이지만, 토비의 스프링에서는 다음과 같이 정의한다.
     * 의존대상 B가 변하면, 그것이 A에 영향을 미친다.
     * 즉, B의 기능이 추가 또는 변경되거나 형식이 바뀌면 그 영향이 A에 미친다.
     */
    @Test
    public void DI_before_encoder_abstract_test() {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        /**
         * 다양한 encoder를 수행하는 클래스가 아래 처럼 존재한다(Base64Encoder.class, UrlEncoder.class)
         * Encoder class는 새롭게 추가되는 다양한 encoder 객체에 의존하게 된다.
         * 즉) 새롭게 encoder class가 추가될 때 마다 Encoder class 변경되어야 한다.
         *
         */
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);
    }

    /**
     * DI Before의 의존관계를 인터페이스로 추상화
     */
    @Test
    public void before_abstract_the_encoder_test() {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        com.example.springreview.DI.abstract_the_encoder.Encoder encoder = new com.example.springreview.DI.abstract_the_encoder.Encoder();

        String result = encoder.encode(url);
        System.out.println(result);

    }

    @Test
    public void DI_after_test() {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        com.example.springreview.DI.after.Encoder encoder = new com.example.springreview.DI.after.Encoder(new UrlEncoder());

        String result = encoder.encode(url);
        System.out.println(result);
    }

}
