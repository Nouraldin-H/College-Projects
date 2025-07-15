package com.algonquincollege.cst8277.rest;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleClientWriterInterceptor implements WriterInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void aroundWriteTo(WriterInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        //only hit if client sends something in the body
        logger.info("SampleClientWriterInterceptor");
        interceptorContext.proceed();
    }

}
