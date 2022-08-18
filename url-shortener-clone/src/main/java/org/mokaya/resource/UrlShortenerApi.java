package org.mokaya.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "UrlShortenerApi")
public interface UrlShortenerApi {
    
    @GET
    @Path("/{alias}")
    @Operation(
        summary = "getUrlShortener",
        description = "get url shortener from alias"
    )

    @APIResponse(
        responseCode = "301",
        description = "Url shortener successfully found"
    )
    @APIResponse(
        responseCode = "404",
        description = "Alias not found"
    )
    @APIResponse(
        responseCode = "400",
        description = "Alias not valid"
    )
    Response getUrlShortener(@PathParam("alias") String alias);

    @POST
    @Operation(
        summary = "createUrlShortener",
        description = "create a new url shortener"
    )

    @APIResponse(
        responseCode = "200",
        description = "Url shortener successfully created"
    )
    @APIResponse(
        responseCode = "409",
        description = "Alias already exists"
    )
    @APIResponse(
        responseCode = "400",
        description = "Input not valid"
    )
    Response createUrlShortener(UrlShortenerDTO urlShortenerDTO);
}
