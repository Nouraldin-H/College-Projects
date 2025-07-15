/*****************************************************************
 * File:  SampleWriterInterceptor.java
 * Course Materials CST 8277
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.rest;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;

@Provider
public class SampleWriterInterceptor implements WriterInterceptor {

    @Context
    protected ServletContext servletContext;

    @Override
    public void aroundWriteTo(WriterInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        servletContext.log("SampleWriterInterceptor");
        interceptorContext.proceed();
    }
    

}
