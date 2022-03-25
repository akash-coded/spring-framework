package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   	  AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   	  
	   	  // raise (publish) ContextSartedEvent event
	   	  context.start();
	   	  System.out.println();
	   	  
	      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	      System.out.println(objA.getMessage1());
	      System.out.println(objA.getMessage2());
	      
	      System.out.println();
	      // raise (publish) ContextStoppedEvent event
	      context.stop();
	      
//	      HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
//	      System.out.println(objB.getMessage1());
//	      System.out.println(objB.getMessage2());
//	      System.out.println(objB.getMessage3());
	      
	      context.registerShutdownHook();
	      
//	   	  AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
//	   	  context2.register(HelloWorldConfig.class);
//	   	  context2.refresh();
//	   	  
//	   	  HelloWorld objC = context2.getBean(HelloWorld.class);
//	   	  objC.setMessage1("Message from HelloWorld using annotation-config context");
//	   	  System.out.println(objC.getMessage1());
//	   	  System.out.println(objC.getMessage2());
//	   	  
//	   	  HelloIndia objD = context2.getBean(HelloIndia.class);
//	   	  objD.setMessage1("Message from HelloIndia using annotation-config context");
//	   	  System.out.println(objD.getMessage1());
//	   	  System.out.println(objD.getMessage2());
//	   	  System.out.println(objD.getMessage3());
	}
}
