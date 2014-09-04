package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.model.MyListModel;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class ListViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public ListViewTestPage() {
        super();

        ListView<Person> listView = new ListView<Person>("listView", new MyListModel(personService)) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Person> item) {
                item.add(new Label("name", new PropertyModel<Person>(item.getModel(), "name")));
            }
            
        };
        add(listView);

    }
}
