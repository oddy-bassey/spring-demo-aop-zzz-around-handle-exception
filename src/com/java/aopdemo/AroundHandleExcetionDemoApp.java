package com.java.aopdemo;
 
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.java.aopdemo.service.TrafficFortuneService; 
public class AroundHandleExcetionDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExcetionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//read spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the AccountDAO bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Calling getFortune");
		
		//add a tripwire to simulate an exception
		boolean tripWire = true;
		
		String data = trafficFortuneService.getFortune(tripWire);
		logger.info("My fortune is: "+data);
		
		logger.info("Finished!");
		
		//close the
		context.close();
	}
}
