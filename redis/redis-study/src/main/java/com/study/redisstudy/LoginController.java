package com.study.redisstudy;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongMin Kim
 */

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        session.setAttribute("name", name);
        return "login";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session) {
        return (String)session.getAttribute("name");
    }

}
