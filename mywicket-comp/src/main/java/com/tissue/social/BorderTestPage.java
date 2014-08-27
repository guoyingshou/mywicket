package com.tissue.social;

import org.apache.wicket.markup.html.border.Border;

import com.tissue.social.borders.MyBorder;
import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class BorderTestPage extends MyTemplateWithMarkupInheritance {

    private static final long serialVersionUID = 1l;

    public BorderTestPage() {
        super();

        Border border = new MyBorder("testborder");
        add(border);
    }

    
}
