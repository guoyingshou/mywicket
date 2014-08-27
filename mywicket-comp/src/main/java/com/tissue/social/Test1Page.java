package com.tissue.social;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class Test1Page extends WebPage {
    private static final long serialVersionUID = 1l;

    private Label f;
    private Label s;

    public Test1Page() {
        Label lb1 = new Label("test1", "hi, ...");
        lb1.setMarkupId("ad1");
        add(lb1);

        AttributeModifier mod = new AttributeModifier("style", "color:red;");
        lb1.add(mod);

        WebMarkupContainer box = new WebMarkupContainer("box");
        Label title = new Label("title", "test title");
        Label content = new Label("content", "test content");

        box.add(title);
        box.add(content);

        add(box);

        f = new Label("label", "first label");
        s = new Label("label", "second label");

        add(f);
        add(new Link<Void>("reload") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                if(getPage().contains(f, true)) {
                    getPage().replace(s);
                }
                else {
                    getPage().replace(f);
                }
            }
            
            @Override
            public void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                System.out.println("+++component: " + this);
            }
        });

    }

}
