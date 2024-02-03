package com.example.springreview;

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

}
