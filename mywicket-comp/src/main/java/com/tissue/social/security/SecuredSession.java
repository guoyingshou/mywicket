package com.tissue.social.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tissue.social.Person;
import com.tissue.social.services.PersonService;

public class SecuredSession extends AuthenticatedWebSession {
    private static final long serialVersionUID = 1L;

    private Person person;

    @SpringBean
    private PersonService personService;

    public SecuredSession(Request req) {
        super(req);
        Injector.get().inject(this);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        person = personService.getPersonByUsernameAndPassword(username, password);
        return person != null;
    }

    @Override
    public Roles getRoles() {
        if(person == null) {
            return null;
        }

        Roles roles = new Roles();
        for(String role : person.getRoles()) {
            roles.add(role);
        }

        return roles;
    }

}
