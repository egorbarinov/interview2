package com.egorbarinov.hibernateapp.controller;

import com.egorbarinov.hibernateapp.entity.Person;
import com.egorbarinov.hibernateapp.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SimpleCrudController {

    private final PersonRepository<Person> repository = new PersonRepository<>(Person.class);

//    @GetMapping("/findById/{id}")
//    @ResponseBody
//    public Person findById(@PathVariable("id") String id) {
//
//        return repository.findById(Person.class, Integer.valueOf(id));
//    }


    @GetMapping("/add-new")
    public String addPerson(Model model, Person person) {
        model.addAttribute("person", person);
        return "creating-person";
    }

    @PostMapping("/creating-person")
    public String addPersonComplete(Model model, Person person){
        model.addAttribute("person", person);
        repository.save(person);

        return "redirect:/findAll";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Person> personList = repository.findAll();
        model.addAttribute("persons", personList);
        return "/getAll";
    }

    @PostMapping("/findAll")
    public String findAllConfirm(Model model) {
        List<Person> personList = repository.findAll();
        model.addAttribute("persons", personList);
        return "getAll";
    }

    @GetMapping("/getById/{id}")
    public String findById(@PathVariable("id") String id, Model model) {
        model.addAttribute("personById", repository.findById(Person.class, Integer.valueOf(id)));
        model.addAttribute("idPersonForDelete", id);

        return "/person";
    }

    @GetMapping("/deletePersonById/{id}") // Person(id=3, name=Monetochka, age=20) removed
    public String deletePerson(@PathVariable("id") String id) {

        repository.delete(repository.findById(Person.class, Integer.valueOf(id)));
        return  "redirect:/findAll";
    }

    @GetMapping("/delete")
    public String delete(Model model, Person person) {
        model.addAttribute("person", person);
        return  "/delete";
    }

    @PostMapping("/delete")
    public String deleteConfirm(Model model, Person person) {
        Person id = repository.findById(Person.class, person.getId());
        repository.delete(id);
        return "redirect:/findAll";
    }



}
