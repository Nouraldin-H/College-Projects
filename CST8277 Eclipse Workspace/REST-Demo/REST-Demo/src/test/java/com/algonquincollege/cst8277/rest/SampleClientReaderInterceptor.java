package com.algonquincollege.cst8277.rest;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleClientReaderInterceptor implements ReaderInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext interceptorContext) throws IOException, WebApplicationException {
        logger.info("SampleClientReaderInterceptor");
        return interceptorContext.proceed();
    }

}
