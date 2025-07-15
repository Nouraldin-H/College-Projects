/*****************************************************************
 * File:  SampleReaderInterceptor.java
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
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class SampleReaderInterceptor implements ReaderInterceptor {

    @Context
    protected ServletContext servletContext;
    
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        servletContext.log("SampleReaderInterceptor");
        return interceptorContext.proceed();
    }

}
