package com.spring.foobar;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.foobar.beans.Bar;
import com.spring.foobar.beans.Foo;

public class FoobarApplication {

	public static void main(String[] args) {
		// launch the application
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Spring foobar app runs!");
		
		Foo f = context.getBean("foo", Foo.class);
		System.out.println(f);
		
		Bar b = context.getBean("bar", Bar.class);
		System.out.println(b);
		
		context.close();
	}

}
