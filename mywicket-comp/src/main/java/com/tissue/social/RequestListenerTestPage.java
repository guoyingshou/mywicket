package com.tissue.social;


import java.util.Collection;

import org.apache.wicket.IRequestListener;
import org.apache.wicket.RequestListenerInterface;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class RequestListenerTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public static interface MyRequestListener extends IRequestListener {
        public static final RequestListenerInterface INTERFACE = new RequestListenerInterface(MyRequestListener.class);

        public void mycallback();
    }

    public RequestListenerTestPage() {
        super();
        setStatelessHint(true);

        StatelessLink<String> link1 = new StatelessLink<String>("link") {
            private static final long serialVersionUID = 1l;
            @Override
            public void onClick() {
                setResponsePage(VersionedTestPage.class);
            }

        };
        add(link1);

        System.out.println(link1.urlFor(MyRequestListener.INTERFACE, null));

        Collection<RequestListenerInterface> infs = RequestListenerInterface.getRegisteredInterfaces();

        System.out.println("==================================");
        for(RequestListenerInterface inf : infs) {
            System.out.println(inf);
        }
        PageParameters params = new PageParameters();
        params.add("name", "guo");
        params.add("page", "2");

        RequestListenerInterface lInf = RequestListenerInterface.forName("ILinkListener");
        System.out.println(lInf);
        System.out.println(link1.urlFor(lInf, params));

        lInf = RequestListenerInterface.forName("IBehaviorListener");
        System.out.println(lInf);
        System.out.println(link1.urlFor(lInf, params));

        System.out.println("==================================");
    }

}
