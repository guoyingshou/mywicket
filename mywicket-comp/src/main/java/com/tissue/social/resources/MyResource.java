package com.tissue.social.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.resource.AbstractResource;

public class MyResource extends AbstractResource {
    private static final long serialVersionUID = 1L;

    @Override
    public ResourceResponse newResourceResponse(Attributes attrs) {
        Request req = attrs.getRequest();
        IRequestParameters params = req.getQueryParameters();
        Set<String> names = params.getParameterNames();
        for(String name : names) {
            System.out.println(name);
        }

        ResourceResponse res = new ResourceResponse();
        res.setWriteCallback(new WriteCallback() {
            @Override
            public void writeData(Attributes attrs) throws IOException {
                OutputStream out = attrs.getResponse().getOutputStream();
                try {
                out.write("fajd".getBytes());
                out.flush();
                }
                finally {
                    if(out != null) {
                        out.close();
                    }
                }
            }
        });
        return res;
    }

}
