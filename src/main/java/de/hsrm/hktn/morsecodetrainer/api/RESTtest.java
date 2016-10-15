package de.hsrm.hktn.morsecodetrainer.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class RESTtest {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "hello: " + msg;

		return Response.status(200).entity(output).build();

	}

}