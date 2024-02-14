package com.example.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobyspringApplication {

	public static void main(String[] args) {
		//Servlet Container Tomcat 띄우기
		TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {

			//Servlet 추가
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

					//Parameter 받는 Method
					String name = req.getParameter("name");

					/*
					 * 웹 응답의 3가지 요소
					 * 1. 상태 라인에서 상태코드
					 * 2. 헤더들을 만들고 그 중에서 Body 어떤 타입인지 Content-type
					 * 3. Body 부분 추가
					 * */

					//String을 하드코딩해서 넣는 방식은 오타 발생 확률이 높아 지향
//					resp.setStatus(200);
//					resp.setHeader("Content-Type", "text/plain");
					resp.setStatus(HttpStatus.OK.value());
					resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
					resp.getWriter().print("Hello " + name);

			//Servlet Container Container에 들어오는 Web 요청을 어느 Servlet 연결해줄 것인가를 결정하는 Mapping 작업
				}
			}).addMapping("/hello");
        });

		webServer.start();
	}

}
