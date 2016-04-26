package com.portal.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.portal.model.User;

@Path("portal")
public class UserController {
	@Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(String details) {
        User user = new User();
        Create create = new Create();
        JSONObject jsonObject, jobj = null;
        jsonObject = new JSONObject(details);
        user.setFirstName(jsonObject.getString("first_name"));
        user.setLastName(jsonObject.getString("last_name"));
        user.setAddress(jsonObject.getString("address"));
        user.setDob(jsonObject.getString("dob"));
        user.setGender(jsonObject.getString("gender"));
        user.setPhoneNumber(jsonObject.getInt("phone_number"));
        user.setBloodGroup(jsonObject.getString("blood_group"));
        user.setUserName(jsonObject.getString("username"));
        user.setPassword(jsonObject.getString("password"));
        int id = create.createOperation(user);
		jobj.put("id","id");
		return Response.ok(jobj).build();
		
    }
	@Path("hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String printMsg() {
		return "hello";
	}
	@Path("login")
	@GET
	public Response loginUser(String userDetails){
		//TODO Do auth here		
		return Response.status(401).build();
	}
	
}
