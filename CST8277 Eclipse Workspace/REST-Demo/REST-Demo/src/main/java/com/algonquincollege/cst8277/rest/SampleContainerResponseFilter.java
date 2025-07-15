/*****************************************************************
 * File:  SampleContainerResponseFilter.java Course Materials CST 8277
 * 
 * @author (original) Mike Norman
 * @author Teddy Yap
 */
package com.algonquincollege.cst8277.rest;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SampleContainerResponseFilter implements ContainerResponseFilter {

	@Context
	protected ServletConfig servletConfig;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		//
		ServletContext servletContext = servletConfig.getServletContext();
		if (servletContext != null) {
			servletContext.log("SampleContainerResponseFilter");
		}

	}

}
