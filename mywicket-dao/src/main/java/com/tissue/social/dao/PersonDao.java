package com.tissue.social.dao;

import java.util.List;

import com.tissue.social.Person;

public interface PersonDao {
    Person getPerson(String id);
    List<Person> getPersons();
}
