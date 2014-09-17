package com.tissue.social.secured;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public abstract class SecuredTestPage extends MyTemplateWithMarkupInheritance {
    @Override
    protected void onConfigure() {
        super.onConfigure();
        if(!AuthenticatedWebSession.get().isSignedIn()) {
            AuthenticatedWebApplication app = (AuthenticatedWebApplication)Application.get();
            app.restartResponseAtSignInPage();
        }
    }
}
