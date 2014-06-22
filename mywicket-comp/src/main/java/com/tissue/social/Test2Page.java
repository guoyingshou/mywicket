package com.tissue.social;

import com.tissue.social.web.fragments.Test2PageFragment;
import com.tissue.social.web.templates.MyTemplate;

public class Test2Page extends MyTemplate {

    private static final long serialVersionUID = 1l;

    public Test2Page() {
        super();
        replace(new Test2PageFragment(MAIN_CONTENT));
        System.out.println("noooo param...");
    }

    /**
    public Test2Page(PageParameters param) {
        System.out.println("param...");

    }
    */

}
