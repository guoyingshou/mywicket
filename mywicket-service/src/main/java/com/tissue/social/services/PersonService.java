package com.tissue.social.services;

import java.util.List;

import com.tissue.social.Person;

public interface PersonService {
    Person getPerson(String id);
    List<Person> getPersons();
    String getPassword(String name);

    Person getPersonByUsernameAndPassword(String username, String password);
}
