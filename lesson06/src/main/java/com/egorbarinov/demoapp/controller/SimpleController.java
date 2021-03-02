package com.egorbarinov.demoapp.controller;



import com.egorbarinov.demoapp.entity.Person;
import com.egorbarinov.demoapp.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SimpleController {

    private final PersonService personService;

    public SimpleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "<h1>Hello, User<h1/>";
    }

    @GetMapping("/findAll")
    public List<Person> allPersons() {
        return personService.getAll();
    }

}
