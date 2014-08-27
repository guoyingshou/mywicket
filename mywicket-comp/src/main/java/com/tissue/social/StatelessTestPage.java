package com.tissue.social;

import java.util.Collection;

import org.apache.wicket.IRequestListener;
import org.apache.wicket.RequestListenerInterface;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class StatelessTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private final Label test;

    public StatelessTestPage() {
        super();
        setStatelessHint(true);

        test = new Label("test", "stateless page test");
        add(test);

        StatelessLink<String> link1 = new StatelessLink<String>("click") {
            private static final long serialVersionUID = 1l;
            @Override
            public void onClick() {
                setResponsePage(VersionedTestPage.class);
            }

        };
        add(link1);

        add(new StatelessLink<String>("click2") {
            private static final long serialVersionUID = 1l;
            @Override
            public void onClick() {
                setResponsePage(StatelessTestPage2.class);
            }

        });

        add(new StatelessLink<String>("click3") {
            private static final long serialVersionUID = 1l;
            @Override
            public void onClick() {
                setResponsePage(StatelessTestPage3.class);
            }

        });

    }

}
