package com.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.*;


public class MainApp {
   public static void main(String[] args) {
	   	  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   	  
	      TextEditor te = (TextEditor) context.getBean("textEditor");
	      te.spellCheck();
	      
	   	  CustomEventPublisher publisher = (CustomEventPublisher) context.getBean("customEventPublisher");
	   	  // raise a custom event
	   	  publisher.publish();
	   
//	   	  ApplicationContext context2 = new AnnotationConfigApplicationContext(SpringInnerBeanConfig.class);
//	   	  
//	   	  TextEditor te = context2.getBean(TextEditor.class);
//	   	  te.spellCheck();
	}
}
