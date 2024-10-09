package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author DongMin Kim
 */
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model m) {
        m.addAttribute("data", "Hello World!");
        return "hello";
    }
}
