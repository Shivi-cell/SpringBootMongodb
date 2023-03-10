package com.SpringBootMongodb.service;

import com.SpringBootMongodb.collection.Person;
import com.SpringBootMongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        List<Person> byFirstNameStartsWith = personRepository.findByFirstNameStartsWith(name);
        return byFirstNameStartsWith;
    }

    @Override
    public void delete(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getByPersonAge(Integer minAge, Integer maxAge) {
        List<Person> byAgeBetween = personRepository.findPersonByAgeBetween(minAge, maxAge);
        return byAgeBetween;
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable) {
        return null;
    }

    /*@Override
    public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            criteria.add(Criteria.where("firstName").regex(name, "i"));
        }
        if (minAge != null && maxAge != null) {
            criteria.add(Criteria.where("age").gt*/

}