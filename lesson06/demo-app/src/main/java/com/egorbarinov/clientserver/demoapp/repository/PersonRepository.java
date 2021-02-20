package com.egorbarinov.clientserver.demoapp.repository;

import com.egorbarinov.clientserver.demoapp.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {

    private final static Map<Integer, Person> personMaps = new HashMap<>();
    private static int count;

    public static void initDataBase() {
        Person person1 = new Person(++count, "Egor Barinov", 38);
        Person person2 = new Person(++count, "Vasya Lozhkin", 45);
        Person person3 = new Person(++count, "Vasya Oblomov", 30);
        personMaps.put(person1.getId(), person1);
        personMaps.put(person2.getId(), person2);
        personMaps.put(person3.getId(), person3);

    }

    public void addPerson(Person person) {
        personMaps.put(++count, person);
    }

    public List<Person> findAll() {
        List<Person> lists = new ArrayList<>(personMaps.values());
        return lists;
    }
}
