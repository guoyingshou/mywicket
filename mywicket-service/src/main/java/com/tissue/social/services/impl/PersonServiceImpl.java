package com.tissue.social.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tissue.social.Person;
import com.tissue.social.dao.PersonDao;
import com.tissue.social.services.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPerson(String id) {
        return personDao.getPerson(id);
    }

    @Override
    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    @Override
    public String getPassword(String name) {
        return personDao.getPassword(name);
    }

    @Override
    public Person getPersonByUsernameAndPassword(String username, String password) {
        return personDao.getPersonByUsernameAndPassword(username, password);
    }

}
