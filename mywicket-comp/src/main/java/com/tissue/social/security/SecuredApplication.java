package com.tissue.social.security;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.tissue.social.HomePage;
import com.tissue.social.resources.MyResource;
import com.tissue.social.secured.meta.MetaSecuredTestPage;

public class SecuredApplication extends AuthenticatedWebApplication {

    @Override
    public void init() {
        super.init();

        //spring integration config start
        /**
         * Besides add the following codes,
         * the ContextLoaderListener need to be configured in web.xml
         * and the spring config file is by default named applicationContext.xml 
         * and should be placed in /WEB-INF directory.
         */
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        //spring integration config end

        //MetaDatRoleAuthorizationStrategy config
        MetaDataRoleAuthorizationStrategy.authorize(MetaSecuredTestPage.class, "admin");

        final MyResource my = new MyResource();
        ResourceReference rr =new ResourceReference("git") {
            private static final long serialVersionUID = 1L;
            @Override
            public IResource getResource() {
                return my;
            }
        };
        mountResource("/r", rr);

        //getSharedResources().add("xmy", my);

    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return SecuredSession.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

}
