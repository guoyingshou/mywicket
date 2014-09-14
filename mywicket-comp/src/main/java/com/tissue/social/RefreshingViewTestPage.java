package com.tissue.social;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class RefreshingViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public RefreshingViewTestPage() {
        super();

        RefreshingView<Person> refreshingView = new RefreshingView<Person>("refreshingView") {
            private static final long serialVersionUID = 1L;
            @Override
            public void populateItem(Item<Person> item) {
                item.add(new Label("name", new PropertyModel<String>(item.getModel(), "name")));
                item.add(new Label("gender", new PropertyModel<String>(item.getModel(), "gender")));
            }

            @Override
            public Iterator<IModel<Person>> getItemModels() {
                List<Person> persons = personService.getPersons();
                List<IModel<Person>> result = persons.stream().map((Person p) -> new LoadableDetachableModel<Person>() {
                    private static final long serialVersionUID = 1l;
                    @Override
                    public Person load() {
                        return p;
                    }
                }).collect(Collectors.toList());

                return result.iterator();
            }
        };
        add(refreshingView);
    }

}
