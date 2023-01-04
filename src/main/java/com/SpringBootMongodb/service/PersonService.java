package com.SpringBootMongodb.service;

import com.SpringBootMongodb.collection.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void delete(String id);

    List<Person> getByPersonAge(Integer minAge, Integer maxAge);

    void deleteAll();

    List<Person> getAll();

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);
}
