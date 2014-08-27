package com.tissue.social.resources;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.wicket.request.resource.AbstractResource;

public class MyResource extends AbstractResource {
    private static final long serialVersionUID = 1L;

    @Override
    public ResourceResponse newResourceResponse(Attributes attrs) {
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
