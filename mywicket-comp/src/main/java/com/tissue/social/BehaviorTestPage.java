package com.tissue.social;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.basic.Label;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class BehaviorTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    private Behavior behavior = new Behavior() {
        private static final long serialVersionUID = 1L;
        @Override
        public void beforeRender(Component comp) {
            System.out.println("in behavior beforRender..." + comp);
        }
    };

    public BehaviorTestPage() {
        super();
        add(behavior);

        Label l = new Label("desc", "my description");
        l.add(behavior);
        add(l);
    }

    
}
