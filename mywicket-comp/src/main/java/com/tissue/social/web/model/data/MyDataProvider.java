package com.tissue.social.web.model.data;

import java.util.Iterator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.Person;
import com.tissue.social.services.PersonService;
import com.tissue.social.web.model.MyModel;

public class MyDataProvider implements IDataProvider<Person> {
    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public MyDataProvider() {
        Injector.get().inject(this);

    }

    @Override
    public Iterator<Person> iterator(long first, long count) {
        return personService.iterator(first, count);
    }

    @Override
    public long size() {
        return personService.getSize();
    }

    @Override
    public IModel<Person> model(Person person) {

        return new MyModel(personService, person.getId());

        /**
        return new LoadableDetachableModel<Person>() {
            private static final long serialVersionUID = 1l;
            @Override
            public Person load() {
                return person;
            }
            @Override
            public void detach() {
                super.detach();
            }
        };
        */
    }

    @Override
    public void detach() {

    }

}
