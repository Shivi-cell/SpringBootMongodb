package com.SpringBootMongodb.service;

import com.SpringBootMongodb.collection.Person;
import com.SpringBootMongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    @Override
    public String save(Person person) {
        return personRepository.save(person).getPersonId();
    }
}
