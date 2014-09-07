package com.tissue.social.secured.role;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

@AuthorizeInstantiation("admin")
public class RoleSecuredTestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1l;

    public RoleSecuredTestPage() {
    }

}
