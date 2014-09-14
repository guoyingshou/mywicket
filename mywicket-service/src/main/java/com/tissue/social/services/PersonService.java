package com.tissue.social.services;

import java.util.Iterator;
import java.util.List;

import com.tissue.social.Person;

public interface PersonService {
    Person getPerson(Integer id);
    List<Person> getPersons();
    //String getPassword(String name);

    Person getPersonByUsernameAndPassword(String username, String password);

    Iterator<Person> iterator(long first, long count);
    int getSize();
}
