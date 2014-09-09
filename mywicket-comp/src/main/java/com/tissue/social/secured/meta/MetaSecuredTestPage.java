package com.tissue.social.secured.meta;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

/**
 * In order to make this page a protected page using MetaDataRoleAuthorizationStrategy,
 * we have to configure it in the Application's init method.
 * see com.tissue.social.security.SecuredApplication for detail.
 */
public class MetaSecuredTestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    public MetaSecuredTestPage() {
    }

}
