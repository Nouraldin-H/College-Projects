/*****************************************************************
 * File:  RestConfig.java
 * Course Materials CST 8277
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.rest;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/v1")
public class RestConfig extends Application {

    /*
     * Without the following 'feature', the default Serialization/Deserialization for Jakarta EE 8
     * is JSON-B, a project called 'Yasson'.
     * 
     * However, it does not 'nicely' handle a variety of issues ... so substitute a non-standard package
     * called 'Jackson (2)'
     */
    
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.jsonFeature", "JacksonFeature");
        return props;
    }
    
    /*
     * If scanning for @Path is not what you want, manually set up
     */
    /*
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> resources = new HashSet<>();
    	resources.add(HelloResource.class);
    	return resources;
    }
    */

}