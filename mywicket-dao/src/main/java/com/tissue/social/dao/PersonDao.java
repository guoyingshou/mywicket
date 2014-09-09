package com.tissue.social.dao;

import java.util.List;

import com.tissue.social.Person;

public interface PersonDao {
    Person getPerson(String id);
    List<Person> getPersons();
    String getPassword(String name);

    Person getPersonByUsernameAndPassword(String username, String password);

    List<Person> getPersons(long first, long count);
    int getSize();
}
