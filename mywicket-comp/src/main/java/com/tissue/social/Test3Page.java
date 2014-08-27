package com.tissue.social;

import java.io.File;

import org.apache.wicket.SharedResources;
import org.apache.wicket.core.request.handler.IPageProvider;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.markup.IMarkupFragment;
import org.apache.wicket.markup.MarkupElement;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.request.resource.SharedResourceReference;

public class Test3Page extends WebPage {
    private static final long serialVersionUID = 1l;

    public Test3Page() {
        super();

        /**
        Thread.dumpStack();
       */

        /**
        IMarkupFragment markup = getMarkup();
        System.out.println("+++size: " + markup.size());
        int count = 1;
        for(MarkupElement ele : markup) {
            System.out.println("-----------------");
            System.out.println(count++ + ": " + ele);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(markup);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        */

        /**
        Label label1 = new Label("l1", "yyy");
        add(label1);

        markup = label1.getMarkup();
        System.out.println("Label's markup..." + markup);
        System.out.println("size: " + markup.size());
        System.out.println("++++++++++++++");
        */

        //Link<String> link1 = new ResourceLink<String>("link1",  new SharedResourceReference("xmy"));
        //Link<String> link1 = new ExternalLink("link1", "http://daronglu.com");
        //Link<String> link1 = new DownloadLink("link1",  new File("xmy"));
        //Link<String> link1 = new BookmarkablePageLink<String>("link1", Test1Page.class);

        Link<String> link1 = new Link<String>("link1"){
            private static final long serialVersionUID = 1l;

            @Override
            public void onClick() {
                /**
                IPageProvider pp = new PageProvider(Test3Page.class);
                System.out.println(">>>has instance?: " + pp.hasPageInstance());
                System.out.println(">>>is new? " + pp.isNewPageInstance());
                System.out.println(">>>page id: " + pp.getPageId());
                System.out.println(">>>render count: " + pp.getRenderCount());

                pp.getPageInstance();
                System.out.println("-------------");

                System.out.println(">>>has instance?: " + pp.hasPageInstance());
                System.out.println(">>>is new? " + pp.isNewPageInstance());
                System.out.println(">>>page id: " + pp.getPageId());
                System.out.println(">>>render count: " + pp.getRenderCount());
                */
 
                //System.out.println(">>>is fresh? " + pp.isPageInstanceFresh());
            }

        };
        add(link1);
        
        /**
        markup = link1.getMarkup();
        System.out.println("link's markup..." + markup);
        System.out.println("size: " + markup.size());
        System.out.println("++++++++++++++");
        */
    }

}
