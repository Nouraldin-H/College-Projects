/*****************************************************************
 * File:  HelloResource.java
 * Course Materials CST 8277
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.rest;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {
    
    @Context
    protected ServletContext servletContext;
    
    @GET
    public Response hello_its_me() {
        MessageHolder mh = new MessageHolder("Hello from Teddy Yap!");
        return Response.ok(mh).build();
    }
    
    @POST
    public Response what(MessageHolder vh) {
        servletContext.log(vh.getMsg());
        return Response.ok().build();
    }
}
