package com.egorbarinov.demoapp.service;


import com.egorbarinov.demoapp.entity.Person;
import com.egorbarinov.demoapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public void setRepository(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {

        return repository.findAll();
    }


}
