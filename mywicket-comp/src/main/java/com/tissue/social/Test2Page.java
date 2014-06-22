package com.tissue.social;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Test2Page extends WebPage {

    private static final long serialVersionUID = 1l;

    public Test2Page() {
        System.out.println("noooo param...");
    }

    public Test2Page(PageParameters param) {
        System.out.println("param...");

    }

}
