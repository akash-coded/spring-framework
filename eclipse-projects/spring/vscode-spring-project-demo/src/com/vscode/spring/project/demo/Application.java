package com.vscode.spring.project.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context-config.xml");

        System.out.println("Spring demo application created with VSCode");

        context.close();
    }
}