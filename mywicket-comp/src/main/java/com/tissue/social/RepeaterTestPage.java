package com.tissue.social;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class RepeaterTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public RepeaterTestPage() {
        super();
        RepeatingView repeatingView = new RepeatingView("repeatingView");
        repeatingView.add(new Label(repeatingView.newChildId(), "a"));
        repeatingView.add(new Label(repeatingView.newChildId(), "b"));
        repeatingView.add(new Label(repeatingView.newChildId(), "c"));
        add(repeatingView);
    }

}
