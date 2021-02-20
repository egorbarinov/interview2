package com.egorbarinov.clientserver.demoapp.controller;

import com.egorbarinov.clientserver.demoapp.entity.Person;
import com.egorbarinov.clientserver.demoapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
