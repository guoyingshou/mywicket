package com.tissue.social;

import java.util.Locale;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1l;

    public HomePage() {
        Label label = new Label("message1", "jfa");
        add(label);

        Model<String> localeModel = new Model<String>() {
            private static final long serialVersionUID = 1L;
            @Override
            public String getObject() {
                System.out.println("Changing locale...");
                return getSession().getLocale().toString();
            }
        };

        add(new Label("currentLocale", localeModel));

        add(new Link<String>("changeLocale") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                getSession().setLocale(Locale.US);
            }
        });

        add(new Link<String>("testlink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Test1Page.class);
            }

        });

        add(new Link<String>("statelesslink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(StatelessTestPage.class);
            }

        });

        add(new StatelessLink<String>("statelesslink2") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                StatelessTestPage2 p2 = new StatelessTestPage2();
                setResponsePage(p2);
            }

        });

        add(new Link<String>("test3pagelink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                Test3Page page = new Test3Page();
                setResponsePage(page);
            }

        });

        add(new Link<String>("ajaxlink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(AjaxTestPage.class);
            }

        });

        add(new ExternalLink("exlink", "http://sina.com.cn")); 

        add(new BookmarkablePageLink<ComponentRenderTestPage>("bookmarkablePageLink", ComponentRenderTestPage.class) {
            private static final long serialVersionUID = 1L;
            
            @Override
            public void onInitialize() {
                super.onInitialize();
                System.out.println("---->>>>>>BookmarkablePageLink onInitialize...");
            }

            @Override
            public void onConfigure() {
                super.onConfigure();
                System.out.println("---->>>>>>BookmarkablePageLink onConfigure...");
            }

            @Override
            public void onBeforeRender() {
                super.onBeforeRender();
                System.out.println("---->>>>>>BookmarkablePageLink onBeforeRender...");
            }

            @Override
            public void onRender() {
                super.onRender();
                System.out.println("---->>>>>>BookmarkablePageLink onRender...");
            }

            @Override
            public void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                System.out.println("---->>>>>>BookmarkablePageLink onComponentTag...");
            }

            @Override
            public void onComponentTagBody(MarkupStream stream, ComponentTag tag) {
                super.onComponentTagBody(stream, tag);
                System.out.println("---->>>>>>BookmarkablePageLink onComponentTagBody...");
            }
  
            @Override
            public void onAfterRenderChildren() {
                super.onAfterRenderChildren();
                System.out.println("---->>>>>>BookmarkablePageLink onAfterRenderChildren...");
            }

            @Override
            public void onAfterRender() {
                super.onAfterRender();
                System.out.println("---->>>>>>BookmarkablePageLink onAfterRender...");
            }

           
        });

    }

}
