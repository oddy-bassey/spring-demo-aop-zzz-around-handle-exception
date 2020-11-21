package com.java.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component; 

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//return a fortune
		return "Expect heavy traffic this evening";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Major exception occurred!");
		}
		
		//reusing getFortune()
		return getFortune();
	}
}

















