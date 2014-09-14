package com.tissue.social.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tissue.social.Person;
import com.tissue.social.dao.PersonDao;

//@Component("personDao")
public class PersonDaoImpl implements PersonDao {

    /**
    @Autowired
    private DataSource ds;
    */

    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person(1, "guo", "M"));
        persons.add(new Person(2, "liu", "F"));
        persons.add(new Person(3, "wan", "F"));
        persons.add(new Person(4, "zha", "M"));
    }

    @Override
    public Person getPerson(Integer id) {
        if("1".equals(id)) {
            return new Person(id, "guo", "M");
        }
        else {
            return new Person(id, "Liu", "F");
        }
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    public String getPassword(String name) {
        return "guo";
    }

    @Override
    public Person getPersonByUsernameAndPassword(String username,
            String password) {
        Person p;
        if("guo".equals(username)) {
            p  = new Person(1, username, "M");
            p.addRole("admin");
        }
        else {
            p  = new Person(2, username, "F");
        }
        return p;
    }

    @Override
    public List<Person> getPagedPersons(long first, long count) {
        if(first >= 4) {
            return new ArrayList<Person>();
        }

        int start = (int)first;
        int end = start + (int)count;
        return persons.subList(start, end);
    }

    @Override
    public int getSize() {
        return 2300;
    }
}
