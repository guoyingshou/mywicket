package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class VersionedTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private final Label test;

    public VersionedTestPage() {
        super();
        test = new Label("test", "versioned page test... every click will modify the labels default model object's value by append '>' symbol to original model object");
        add(test);

        add(new Link<String>("click") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                Object mobj = test.getDefaultModelObject();
                test.setDefaultModelObject(mobj + ">");
            }

        });

        add(new Link<String>("link") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(StatelessTestPage.class);
            }

        });

    }

}
