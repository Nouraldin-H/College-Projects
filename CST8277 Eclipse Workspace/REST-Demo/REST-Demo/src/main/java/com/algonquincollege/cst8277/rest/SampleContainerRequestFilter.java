/*****************************************************************
 * File:  SampleContainerRequestFilter.java Course Materials CST 8277
 * 
 * @author (original) Mike Norman
 * @author Teddy Yap
 */
package com.algonquincollege.cst8277.rest;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

//no @PreMatching annotation
@Provider
public class SampleContainerRequestFilter implements ContainerRequestFilter {

	@Context
	protected ServletContext servletContext;

	@Context
	protected HttpServletRequest httpServletRequest;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		servletContext.log("SampleContainerRequestFilter");
		String contentType = httpServletRequest.getContentType();
		servletContext.log("contentType = " + contentType);
	}

}
