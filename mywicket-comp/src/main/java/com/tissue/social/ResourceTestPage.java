package com.tissue.social;

import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.ContextRelativeResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReferenceRegistry;
import org.apache.wicket.request.resource.SharedResourceReference;

import com.tissue.social.resources.MyResource;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class ResourceTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public ResourceTestPage() {
        super();

        Model<String> localeModel = new Model<String>() {
            private static final long serialVersionUID = 1L;
            @Override
            public String getObject() {
                System.out.println("Changing locale...");
                return getSession().getLocale().toString();
            }
        };

        add(new Label("currentLocale", localeModel));

        add(new Link<String>("changeLocale") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                getSession().setLocale(Locale.US);
            }
        });


        ResourceReferenceRegistry reg = Application.get().getResourceReferenceRegistry();
        System.out.println("+++++" + reg.getSize());

        //guo.jpg is located relative to package
        PackageResourceReference rr = new PackageResourceReference(getClass(), "images/guo.jpg");
        add(new Image("testimg", rr));

        //Image.png is located in webroot
        add(new Image("testimg2", new ContextRelativeResource("/images/Image.png")));

        //test i18n
        add(new Label("testmsgUsingResourceBundle", new ResourceModel("testkey")));

        //instantiate the resource and make it directly accessible.
        add(new ResourceLink<String>("rlink1", new MyResource()));

        //register the resource first as shared resource in Application's init() and make it accessible.
        add(new ResourceLink<String>("rlink2", new SharedResourceReference("xmy")));

        //the same resource has been mounted on segment "/my" too.
        
    }

    /**
    @Override
    public void renderHead(IHeaderResponse response) {
        //css resource is located in relative to package 
        PackageResourceReference css = new PackageResourceReference(getClass(), "css/style1.css");
        CssHeaderItem item = CssHeaderItem.forReference(css);
        response.render(item);
    }
    */

}
