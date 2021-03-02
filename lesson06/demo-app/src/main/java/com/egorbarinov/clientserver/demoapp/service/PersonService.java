package com.egorbarinov.clientserver.demoapp.service;


import com.egorbarinov.clientserver.demoapp.entity.Person;
import com.egorbarinov.clientserver.demoapp.repository.PersonRepository;
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
