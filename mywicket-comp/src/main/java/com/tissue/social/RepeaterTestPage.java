package com.tissue.social;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class RepeaterTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private List<String> names = Arrays.asList("guo", "liu", "wang");

    public RepeaterTestPage() {
        super();

        ListView<String> listView = new ListView<String>("listView", names) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<String> item) {
                item.add(new Label("name", item.getModel()));
            }
            
        };
        add(listView);

        ListView<Person> propertyListView = new PropertyListView<Person>("propertyListView", getPersons()) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Person> item) {
                item.add(new Label("firstName"));
                item.add(new Label("lastName"));
            }
        };
        add(propertyListView);

        PageableListView<Person> pageableListView = new PageableListView<Person>("pageableListView", getPersons(), 2) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Person> item) {
                item.add(new Label("firstName", item.getModelObject().getFirstName()));
                item.add(new Label("lastName", item.getModelObject().getLastName()));
            }
        };
        add(pageableListView);
        add(new AjaxPagingNavigator("nav", pageableListView));

        //repeating view
        RepeatingView repeatingView = new RepeatingView("repeatingView");
        repeatingView.add(new Label(repeatingView.newChildId(), "a"));
        repeatingView.add(new Label(repeatingView.newChildId(), "b"));
        repeatingView.add(new Label(repeatingView.newChildId(), "c"));
        add(repeatingView);

        //refreshing view
        final List<IModel<Person>> listOfModels = new ArrayList<IModel<Person>>();
        List<Person> persons = getPersons();
        for(Person person : persons) {
            listOfModels.add(Model.of(person));
        }

        RefreshingView<Person> refreshingView = new RefreshingView<Person>("refreshingView") {
            private static final long serialVersionUID = 1L;
            @Override
            public void populateItem(Item<Person> item) {
                item.add(new Label("firstName", new PropertyModel<String>(item.getModel(), "firstName")));
                item.add(new Label("lastName", new PropertyModel<String>(item.getModel(), "lastName")));
            }

            @Override
            public Iterator<IModel<Person>> getItemModels() {
                return listOfModels.iterator();
            }
            
        };
        add(refreshingView);


        ListDataProvider<Person> listDataProvider = new ListDataProvider<Person>(getPersons());
        DataView<Person> dataView = new DataView<Person>("dataView", listDataProvider) {
            private static final long serialVersionUID = 1L;
            @Override
            public void populateItem(Item<Person> item) {
                Person person = item.getModelObject();
                RepeatingView row = new RepeatingView("dataRow");
                row.add(new Label(row.newChildId(), new PropertyModel<String>(person, "firstName")));
                row.add(new Label(row.newChildId(), new PropertyModel<String>(person, "lastName")));
                item.add(row);
            }
            
        };
        add(dataView);
        dataView.setItemsPerPage(2);
        add(new PagingNavigator("nav2", dataView));

    }

    private List<Person> getPersons() {
        List<Person> persons = Arrays.asList(new Person("guo", "yi"), new Person("liu", "san"), new Person("wang", "si"));
        return persons;
    }

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /**
         * @return the firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @param firstName the firstName to set
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * @return the lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @param lastName the lastName to set
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }
}
