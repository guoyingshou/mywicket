package com.tissue.social.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tissue.social.Person;
import com.tissue.social.dao.PersonDao;

@Component("personDao")
public class PersonDaoImpl implements PersonDao {

    @Override
    public Person getPerson(String id) {
        if("1".equals(id)) {
            return new Person(id, "guo", 'M');
        }
        else {
            return new Person(id, "Liu", 'F');
        }
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("1", "guo", 'M'));
        persons.add(new Person("2", "liu", 'F'));
        persons.add(new Person("3", "wan", 'F'));
        persons.add(new Person("4", "zha", 'M'));
        return persons;
    }

}
