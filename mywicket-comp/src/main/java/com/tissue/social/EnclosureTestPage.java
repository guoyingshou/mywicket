package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class EnclosureTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private Label msg;

    public EnclosureTestPage() {
        super();

        msg = new Label("msg", "test text that will be displayed and hidden...");
        add(msg);

        add(new Link<String>("toggle") {
            private static final long serialVersionUID = 1L;

            public void onClick() {
                msg.setVisible(!msg.isVisible());
            }
        });
    }
    
}
