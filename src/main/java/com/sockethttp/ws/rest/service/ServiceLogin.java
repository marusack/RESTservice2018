package com.sockethttp.ws.rest.service;



import com.sockethttp.ws.rest.vo.Message;
import com.sockethttp.ws.rest.vo.VOUser;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class ServiceLogin {

    @POST
    @Path("/validation")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})//castea el object to json
    public VOUser validation(VOUser user){
        user.setStatus(false);
        if (user.getUser().equals("admin") && user.getPassword().equals("1234")){
            user.setStatus(true);
        }
        return user;
    }
    
    
    
    @POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(VOUser user) {
		String result = "User created : " + user;
		return Response.status(201).entity(result).build();
		
	}
    
    @GET
    @Path("/message")
    @Produces({MediaType.APPLICATION_JSON})//castea el object to json
    public Message message(String user, String pass){
    	Message mes = new Message("Welcome to the site"+user);
        return mes;
    }
}
