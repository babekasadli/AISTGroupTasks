package app.backend.geo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/geocoding")
public class GeocodingResource {
    @Inject
    private GeocodingService geocodingService;

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("q") String query) {
        String jsonResponse = geocodingService.search(query);
        return Response.ok(jsonResponse).header("Content-Type", "application/json; charset=UTF-8").build();
    }

    @GET
    @Path("/reverse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reverse(@QueryParam("lat") String latitude, @QueryParam("lon") String longitude) {
        String jsonResponse = geocodingService.reverse(latitude, longitude);
        return Response.ok(jsonResponse).header("Content-Type", "application/json; charset=UTF-8").build();
    }
}
