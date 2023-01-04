package com.SpringBootMongodb.controller;

import com.SpringBootMongodb.collection.Person;
import com.SpringBootMongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    public String Save(@RequestBody Person person)
    {
        return personService.save(person);
    }
}
