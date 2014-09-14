package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.PropertyModel;

import com.tissue.social.web.model.data.MyDataProvider;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class DataViewTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public DataViewTestPage() {
        super();

        IDataProvider<Person> listDataProvider = new MyDataProvider();

        DataView<Person> dataView = new DataView<Person>("dataView", listDataProvider) {
            private static final long serialVersionUID = 1L;

            /**
             * It's important to notice here that we need to use IChainingModel's feature to
             * avoid the serialization of the containing Label model object.
             */
            @Override
            public void populateItem(Item<Person> item) {
                RepeatingView row = new RepeatingView("dataRow");
                row.add(new Label(row.newChildId(), new PropertyModel<String>(item.getModel(), "name")));
                row.add(new Label(row.newChildId(), new PropertyModel<String>(item.getModel(), "gender")));
                item.add(row);
            }
        };
        dataView.setItemsPerPage(2);
        add(dataView);

        add(new PagingNavigator("nav2", dataView));

    }

}
