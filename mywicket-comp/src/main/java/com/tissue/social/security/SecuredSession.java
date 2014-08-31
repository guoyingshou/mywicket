package com.tissue.social.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class SecuredSession extends AuthenticatedWebSession {
    private static final long serialVersionUID = 1L;

    public SecuredSession(Request req) {
        super(req);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return username.equals("guo") && password.equals("guo");
    }

    @Override
    public Roles getRoles() {
        return null;
    }

}
