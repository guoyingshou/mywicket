package com.tissue.social;

import org.apache.wicket.markup.ComponentTag;
/**
import org.apache.wicket.markup.IMarkupFragment;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.MarkupElement;
*/
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class Test4Page extends WebPage {
    private static final long serialVersionUID = 1l;

    public Test4Page() {
        super();

        Label l = new Label("msg", "hello...") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onConfigure() {
                super.onConfigure();
                Thread.dumpStack();
            }

            @Override
            public void onInitialize() {
                super.onInitialize();
                Thread.dumpStack();
            }

            @Override
            public void onBeforeRender() {
                super.onBeforeRender();
                Thread.dumpStack();
            }

            @Override
            public void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                Thread.dumpStack();
            }

            @Override
            public void onComponentTagBody(MarkupStream stream, ComponentTag openTag) {
                super.onComponentTagBody(stream, openTag);
                Thread.dumpStack();
            }

        };
        add(l);

        Link<String> link = new Link<String>("link") {
            private static final long serialVersionUID = 1l;

            @Override
            public void onClick() {
                setResponsePage(Test3Page.class);
            }
        };

        add(link);

        /**
        IMarkupFragment markup = getMarkup();
        System.out.println("page markup size: " + markup.size());
        int count = 1;
        for(MarkupElement ele : markup) {
            System.out.println(count++ + ": " + ele  + ", class: " + ele.getClass() + "\n");
        }
        System.out.println("=====================");
        
        markup = l.getMarkup();

        System.out.println("label markup size: " + markup.size());

        count = 1;
        for(MarkupElement ele : markup) {
            System.out.println(count++ + ": " + ele + ", class: " + ele.getClass() + "\n");
        }
        System.out.println("---------------------");
        
        markup = link.getMarkup();

        System.out.println("link markup size: " + markup.size());

        count = 1;
        for(MarkupElement ele : markup) {
            System.out.println(count++ + ": " + ele + ", class: " + ele.getClass() + "\n");
        }
        System.out.println("---------------------");
        */

    }

}
