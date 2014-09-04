package com.tissue.social.web.model;

import java.util.List;

import org.apache.wicket.model.LoadableDetachableModel;

import com.tissue.social.Person;
import com.tissue.social.services.PersonService;

public class MyListModel extends LoadableDetachableModel<List<Person>> {
    private static final long serialVersionUID = 1l;

    private PersonService personService;

    public MyListModel(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected List<Person> load() {
        return personService.getPersons();
    }

    @Override
    protected void onDetach() {
        super.onDetach();
    }
}


