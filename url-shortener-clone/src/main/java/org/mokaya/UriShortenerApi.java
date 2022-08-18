package org.mokaya;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UriShortenerApi {
    
    @GET
    @Path("/{alias}")
    Response getUrlShortener(@PathParam("alias") String alias);

    @POST
    Response createUrlShortener(UrlShortenerDTO urlShortenerDTO);
}
