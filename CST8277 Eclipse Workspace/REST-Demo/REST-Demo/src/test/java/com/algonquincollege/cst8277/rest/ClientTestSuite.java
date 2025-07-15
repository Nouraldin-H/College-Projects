/*****************************************************************
 * File:  ClientTestSuite.java
 * Course materials CST 8277
 * @author (original) Mike Norman
 *
 */
package com.algonquincollege.cst8277.rest;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.invoke.MethodHandles;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import com.algonquincollege.cst8277.rest.MessageHolder;

public class ClientTestSuite {
    private static final Class<?> _thisClaz = MethodHandles.lookup().lookupClass();
    private static final Logger logger = LoggerFactory.getLogger(_thisClaz);
    
    public static final String HELLO_MSG = "Hello from Teddy Yap!";
    
    protected WebTarget webTarget;
    protected ObjectMapper mapper;

    @BeforeEach
    public void setUp() throws Exception {
        mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.setMapper(mapper);
        Client client = ClientBuilder.newBuilder().register(provider).build();
        UriBuilder uriBuilder = UriBuilder.fromUri("")
           .scheme("http")
           .host("localhost")
           .port(8080)
           .path("REST-Demo/api/v1");
        webTarget = client.target(uriBuilder);
    }

    @Test
    public void test_hello_get() {
        Response response = webTarget
            .path("hello")
            .request(APPLICATION_JSON)
            .get();
        assertThat(response.getStatus(), is(200));
        MessageHolder msgH = response.readEntity(MessageHolder.class);
        logger.info(msgH.toString());
        assertEquals(HELLO_MSG, msgH.getMsg());
    }

    @Test
    public void test_hello_media_isnot_xml() {
        Response response = webTarget
            .path("hello")
            .request(APPLICATION_JSON)
            .get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(not(MediaType.APPLICATION_XML)));
        
    }

}