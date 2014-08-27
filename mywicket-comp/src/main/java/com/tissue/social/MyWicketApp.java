package com.tissue.social;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

import com.tissue.social.resources.MyResource;

public class MyWicketApp extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();

        //shared resource registration
        final MyResource my = new MyResource();
        getSharedResources().add("xmy", my);

        //mount resource
        ResourceReference rr =new ResourceReference("myres") {
            private static final long serialVersionUID = 1L;
            @Override
            public IResource getResource() {
                return my;
            }
        };
        mountResource("/my", rr);

        //testing mounted mapper...
        mountPage("/mnt1", MountedMapperTestPage.class);
        mountPage("/mnt2/${name}/${age}", MountedMapperTestPage.class);
        mountPage("/mnt3/${name}/#{age}", MountedMapperTestPage.class);

        /**
        mountPage("/m1", StatelessTestPage.class);
        mountPage("/m2", StatelessTestPage2.class);
        mountPage("/m3", StatelessTestPage3.class);
        */
    }
}
