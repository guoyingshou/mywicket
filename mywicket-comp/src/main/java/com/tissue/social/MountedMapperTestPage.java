package com.tissue.social;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class MountedMapperTestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1l;

    public MountedMapperTestPage() {
        super();
    }

    public MountedMapperTestPage(PageParameters params) {
        System.out.println("Params: " + params);
    }


}
