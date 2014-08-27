package com.tissue.social;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.cycle.RequestCycle;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class AjaxTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public AjaxTestPage() {
        super();

        final Label ajaxcontent = new Label("ajaxcontent", "old content");
        ajaxcontent.setOutputMarkupId(true);
        add(ajaxcontent);

        add(new AjaxLink<Void>("ajaxlink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target) {

                /**
                System.out.println("+++++++++++++++++onclick start");
                Request req = RequestCycle.get().getRequest();
                Url url = req.getUrl();
                System.out.println("url: " + url);
                Url curl = req.getClientUrl();
                System.out.println("clientUrl: " + curl);
                System.out.println("+++++++++++++++++onclick stop");
                */

                ajaxcontent.setDefaultModelObject(new Date().toString());
                target.add(ajaxcontent);
            }
        });

    }

}
