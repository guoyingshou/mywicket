package com.tissue.social;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class DataViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public DataViewTestPage() {
        super();

        ListDataProvider<Person> listDataProvider = new ListDataProvider<Person>() {
            private static final long serialVersionUID = 1l;

            @Override
            public List<Person> getData() {
                return new ArrayList<>();
            }

            @Override
            public Iterator<Person> iterator(long first, long count) {
                return personService.iterator(first, count);
            }

            @Override
            public long size() {
                return personService.getSize();
            }

        };

        DataView<Person> dataView = new DataView<Person>("dataView", listDataProvider) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(Item<Person> item) {
                Person person = item.getModelObject();
                RepeatingView row = new RepeatingView("dataRow");
                row.add(new Label(row.newChildId(), new PropertyModel<String>(person, "name")));
                row.add(new Label(row.newChildId(), new PropertyModel<String>(person, "gender")));
                item.add(row);
            }
            
        };
        dataView.setItemsPerPage(2);
        add(dataView);

        add(new PagingNavigator("nav2", dataView));

    }

}
