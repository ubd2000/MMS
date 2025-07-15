package com.study.pubsubchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PubSubChatApplication implements CommandLineRunner {

	@Autowired
	private ChatService chatService;

	public static void main(String[] args) {
		SpringApplication.run(PubSubChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("PubSubChatApplication started successfully!");

		chatService.enterCharRoom("chat-room-1");

	}


}