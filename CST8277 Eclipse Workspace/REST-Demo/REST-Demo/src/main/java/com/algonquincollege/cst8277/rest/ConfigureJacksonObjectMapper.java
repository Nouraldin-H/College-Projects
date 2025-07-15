/*****************************************************************
 * File:  ConfigureJacksonObjectMapper.java Course Materials CST 8277
 * 
 * @author (original) Mike Norman
 * @author Teddy Yap
 */
package com.algonquincollege.cst8277.rest;

import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

@Provider
public class ConfigureJacksonObjectMapper extends JacksonJsonProvider implements ContextResolver<ObjectMapper> {
		
	static ObjectMapper defaultObjectMapper;
	static {
		defaultObjectMapper = new ObjectMapper()
	        .registerModule(new JavaTimeModule())
	        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
    public ConfigureJacksonObjectMapper() {
    	super(defaultObjectMapper);
    }
    
    public ObjectMapper getContext(Class<?> type) {
            return defaultObjectMapper;
    }

}