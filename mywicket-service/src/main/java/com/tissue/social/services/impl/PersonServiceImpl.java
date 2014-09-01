package com.tissue.social.services.impl;

import org.springframework.stereotype.Service;

import com.tissue.social.Person;
import com.tissue.social.services.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    public Person getPerson(String id) {
        if("1".equals(id)) {
            return new Person(id, "guo", 'M');
        }
        else {
            return new Person(id, "Liu", 'F');
        }
    }

}
