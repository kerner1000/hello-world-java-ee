package org.example.ws;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class AuthInterceptor implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        // X-AUTH header
        String headerValue = context.getHeaderString("X-AUTH");
        if(headerValue == null || !headerValue.equals("sicher!")){
            Response.ResponseBuilder responseBuilder = Response.status(Response.Status.EXPECTATION_FAILED);
            Response response =  responseBuilder.build();
            context.abortWith(response);
        }
    }
}
