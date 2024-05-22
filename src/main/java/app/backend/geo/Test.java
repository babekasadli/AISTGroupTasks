package app.backend.geo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/test")
public class Test {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello! Server is running!";
    }
}