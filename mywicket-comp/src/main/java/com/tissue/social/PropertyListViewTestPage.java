package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.model.MyListModel;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class PropertyListViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public PropertyListViewTestPage() {
        super();

        ListView<Person> propertyListView = new PropertyListView<Person>("propertyListView", new MyListModel(personService)) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Person> item) {
                item.add(new Label("name"));
                item.add(new Label("gender"));
            }
        };
        add(propertyListView);

    }
}
