/**
 * 
 */
package com.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.demo.beans.Bar;
import com.spring.demo.beans.Foo;

/**
 * @author Akash
 *
 */
public class SpringAppDemoDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context-config.xml");
		
		System.out.println("My Spring application runs!");
		
		Foo f = context.getBean("foo", Foo.class);
		System.out.println(f);
		
		Bar b = context.getBean("bar", Bar.class);
		System.out.println(b);
		
		System.out.println("Closing the application...");
		context.close();
	}

}
