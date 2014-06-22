package com.tissue.social;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class MyWicketApp extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }
}
