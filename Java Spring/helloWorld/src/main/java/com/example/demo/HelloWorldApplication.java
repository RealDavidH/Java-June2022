package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//1. Annotation
@RestController
public class HelloWorldApplication {
     public static void main(String[] args) {
             SpringApplication.run(HelloWorldApplication.class, args);
     }
     
     // 1. Annotation
     @RequestMapping("/")
     // 3. Method that maps to the request route above
     public String hello() { // 3
             return "Hello World!";
     }
     @RequestMapping("/new_route")
     public String test() {
    	 return "Yo mama";
     }
}
