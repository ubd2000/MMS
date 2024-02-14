package com.example.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ubd2000
 */
public class FrontController {
    public static void main(String[] args) {
        //Spring container 생성
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        //Bean 등록
        applicationContext.registerBean(HelloController.class);
        //Bean 생성
        applicationContext.refresh();

        //Servlet Container Tomcat 띄우기
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
//            HelloController helloController = new HelloController();

            //Servlet 추가
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능 공통 영역
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");

                        //request parameter 바인딩
                        HelloController helloController = applicationContext.getBean(HelloController.class);
                        String ret = helloController.hello(name);

                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().print(ret);

                    } else if (req.getRequestURI().equals("/user")) {

                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });

        webServer.start();
    }

}
