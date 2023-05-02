package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String hello() {
		return "Hello Service";
	}
	
	public String bonjour(String name) {
		return "Bonjour " + name;
	}

}
