package com.tissue.social.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tissue.social.Person;
import com.tissue.social.dao.PersonDao;

@Component("personDao")
public class PersonDaoImpl implements PersonDao {

    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("1", "guo", 'M'));
        persons.add(new Person("2", "liu", 'F'));
        persons.add(new Person("3", "wan", 'F'));
        persons.add(new Person("4", "zha", 'M'));
    }

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
        return persons;
    }

    @Override
    public String getPassword(String name) {
        return "guo";
    }

    @Override
    public Person getPersonByUsernameAndPassword(String username,
            String password) {
        Person p;
        if("guo".equals(username)) {
            p  = new Person("1", username, 'M');
            p.addRole("admin");
        }
        else {
            p  = new Person("2", username, 'F');
        }
        return p;
    }

    @Override
    public List<Person> getPersons(long first, long count) {
        int start = (int)first;
        int end = start + (int)count;
        return persons.subList(start, end);
    }

    @Override
    public int getSize() {
        return persons.size();
    }
}
