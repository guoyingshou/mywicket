package com.tissue.social;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ComponentRenderTestPage extends WebPage {

    private static final long serialVersionUID = 1l;

    public ComponentRenderTestPage() {
        Label label = new Label("message1", "label text");
        add(label);

        Label label2 = new Label("message2", "another label text");
        add(label2);
    }

}
