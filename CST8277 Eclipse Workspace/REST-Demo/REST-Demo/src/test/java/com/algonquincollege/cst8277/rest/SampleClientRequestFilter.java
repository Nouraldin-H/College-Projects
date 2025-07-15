package com.algonquincollege.cst8277.rest;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleClientRequestFilter implements ClientRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        logger.info("SampleClientRequestFilter");
    }

}
