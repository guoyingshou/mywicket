package com.tissue.social;


import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class FragmentTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private Fragment frag1;
    private Fragment frag2;

    public FragmentTestPage() {
        super();
    }

    @Override
    public void onInitialize() {
        super.onInitialize();

        frag1 = new Fragment("content", "frag1", this);
        frag2 = new Fragment("content", "frag2", this);
        add(frag1);

        add(new Link<String>("click") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                frag1.replaceWith(frag2);
            }
        });
    }



}
