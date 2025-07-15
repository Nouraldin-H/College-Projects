/*****************************************************************
 * File:  SamplePreMatchContainerRequestFilter.java
 * Course Materials CST 8277
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.rest;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

@PreMatching
@Provider
public class SamplePreMatchContainerRequestFilter implements ContainerRequestFilter {

    @Context
    protected ServletContext servletContext;

    @Context
    protected HttpServletRequest httpServletRequest;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        servletContext.log("SamplePreMatchContainerRequestFilter");
        String contentType = httpServletRequest.getContentType();
        servletContext.log("contentType = " + contentType);
    }

}
