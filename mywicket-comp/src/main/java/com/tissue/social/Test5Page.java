package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.services.PersonService;
import com.tissue.social.web.model.MyModel;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class Test5Page extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    @SpringBean
    private PersonService personService;

    public Test5Page(PageParameters params) {
        super();

        String id = params.get("id").toString();

        Label l = new Label("msg", new PropertyModel<Person>(new MyModel(personService, id), "name"));
        add(l);

    }

}
