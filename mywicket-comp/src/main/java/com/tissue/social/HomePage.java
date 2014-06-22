package com.tissue.social;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1l;

    public HomePage() {
        Form<String> form = new Form<String>("testForm");
        add(form);

        Page page = form.getPage();
        System.out.println(page);

        add(new Label("message1", "jfa"));
        add(new Link<String>("test1") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Test1Page.class);
            }

        });
    }

}
