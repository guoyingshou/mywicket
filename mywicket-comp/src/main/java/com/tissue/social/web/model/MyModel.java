package com.tissue.social.web.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.tissue.social.Person;
import com.tissue.social.services.PersonService;

public class MyModel extends LoadableDetachableModel<Person> {
    private static final long serialVersionUID = 1l;

    private Integer personId;
    private PersonService personService;

    public MyModel(PersonService personService, Integer personId) {
        this.personService = personService;
        this.personId = personId;
    }

    /**
     * @return the personId
     */
    public Integer getPersonId() {
        return personId;
    }


    /**
     * @param personId the personId to set
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    protected Person load() {
        Person p = personService.getPerson(personId);
        return p;
    }

    @Override
    protected void onDetach() {
        super.onDetach();
    }
}


