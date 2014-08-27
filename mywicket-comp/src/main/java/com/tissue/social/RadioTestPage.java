package com.tissue.social;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class RadioTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    final RadioGroup<String> group;

    public RadioTestPage() {
        super();

        Form<Void> form = new Form<Void>("form") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onSubmit() {
                System.out.println(group.getModelObject());

            }
        };
        add(form);

        IModel<String> selected = new Model<String>();
        group = new RadioGroup<>("group", selected);
        form.add(group);

        group.add(new Radio<String>("aapl", new Model<String>("AAPL")));
        group.add(new Radio<String>("goog", new Model<String>("GOOG")));
        group.add(new Radio<String>("msft", new Model<String>("MSFT")));
        
    }

    
}
