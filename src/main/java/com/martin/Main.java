package com.martin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello, Its Wainaina";
    }

    //http://localhost:8080/jambo
    @GetMapping("/jambo")
    public JamboResponse jambo(){
                JamboResponse response = new JamboResponse("Sijambo",
                List.of("Java", "C", "C+"),
                new Person("Martin", 23, 6000)
        );
                return response;
    }

    //java equivalent o class, constructor, getter, setter.
    record JamboResponse(String jambo,
                         List<String> favLanguages,
                         Person person
                         ){

    }

    record Person(String name, int age, double savings){}
}
