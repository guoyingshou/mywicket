package com.tissue.social;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.model.MyListModel;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class PageableListViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public PageableListViewTestPage() {
        super();

        PageableListView<Person> pageableListView = new PageableListView<Person>("pageableListView", new MyListModel(personService), 2) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Person> item) {
                item.add(new Label("name", item.getModelObject().getName()));
                item.add(new Label("gender", item.getModelObject().getGender()));
            }
        };
        add(pageableListView);
        add(new AjaxPagingNavigator("nav", pageableListView));
    }
}
