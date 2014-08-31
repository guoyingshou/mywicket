package com.tissue.social.secured;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.link.Link;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class SecuredTestPage1 extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    public SecuredTestPage1() {

    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        if(!AuthenticatedWebSession.get().isSignedIn()) {
            AuthenticatedWebApplication app = (AuthenticatedWebApplication)Application.get();
            app.restartResponseAtSignInPage();
        }
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Link<Void>("signout") {
            private static final long serialVersionUID = 1l;
            @Override
            public void onClick() {
                AuthenticatedWebSession.get().invalidate();
                setResponsePage(getApplication().getHomePage());
            }

        });
    }

}
