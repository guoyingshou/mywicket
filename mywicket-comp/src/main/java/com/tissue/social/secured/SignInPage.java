package com.tissue.social.secured;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class SignInPage extends MyTemplateWithMarkupInheritance {

    private String username;
    private String password;

    public SignInPage() {

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        StatelessForm<SignInPage> form = new StatelessForm<SignInPage>("signInForm") {

            @Override
            protected void onSubmit() {
                if(Strings.isEmpty(username)) {
                    return;
                }

                boolean result = AuthenticatedWebSession.get().signIn(username, password);
                if(result) {
                    continueToOriginalDestination();
                }
                
            }

        };
        add(form);

        form.setDefaultModel(new CompoundPropertyModel<SignInPage>(this));
        form.add(new TextField<String>("username"));
        form.add(new PasswordTextField("password"));

    }

}

