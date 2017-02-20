package com.zqs.core.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/test")
public interface TestService {
	
	@POST
	@Path("/hi")
	String hi();
}
