package com.tissue.social.dao;

import java.util.List;

import com.tissue.social.Person;

public interface PersonDao {

    List<Person> getPersons();
    
    Person getPerson(Integer id);

    //String getPassword(String name);

    Person getPersonByUsernameAndPassword(String username, String password);

    List<Person> getPagedPersons(long first, long count);

    int getSize();
}
