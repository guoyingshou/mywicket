package com.tissue.social.web.templates;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MyTemplate extends WebPage {
    private static final long serialVersionUID = 1L;

    public static final String MAIN_CONTENT = "main_content";

    private Component headerPanel;
    private Component footerPanel;

    public MyTemplate() {
        headerPanel = new HeaderPanel("header");
        footerPanel = new FooterPanel("footer");

        add(headerPanel);
        add(footerPanel);

        add(new Label(MAIN_CONTENT, "to be replaced"));
    }

}
