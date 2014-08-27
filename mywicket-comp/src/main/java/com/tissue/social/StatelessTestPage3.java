package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.StatelessLink;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class StatelessTestPage3 extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private final Label test;

    public StatelessTestPage3() {
        super();
        setStatelessHint(true);

        test = new Label("test", "stateless page3 test");
        add(test);

        add(new StatelessLink<String>("click") {

            @Override
            public void onClick() {
                System.out.println("link clicked...");
            }

        });
    }

}
