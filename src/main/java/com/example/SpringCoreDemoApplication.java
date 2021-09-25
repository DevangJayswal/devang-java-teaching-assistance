package com.example;

import com.example.inversionofcontrol.dependencyinjection.a.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringCoreDemoApplication.class, args);
        propertyInjection(context);

    }

    static void propertyInjection(ApplicationContext context){
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());
    }

}
