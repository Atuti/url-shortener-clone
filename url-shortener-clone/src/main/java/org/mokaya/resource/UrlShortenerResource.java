package org.mokaya.resource;

import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mokaya.UrlShortenerMapper;
import org.mokaya.entity.UrlShortener;
import org.mokaya.exception.UrlShortenerException;
import org.mokaya.service.UrlShortenerService;

public class UrlShortenerResource implements UrlShortenerApi{

    @ConfigProperty(name = "exception.message.url_not_created")
    public String URL_NOT_CREATED;

    @Inject
    UrlShortenerService urlService;

    @Inject
    UrlShortenerMapper urlMapper;

    @Override
    public Response getUrlShortener(String alias) {

        return urlService.getUrlShortener(alias)
                .map(url -> Response.status(Response.Status.MOVED_PERMANENTLY)
                            .header("location", url.getUrl())
                            .build()
                ).orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @Override
    public Response createUrlShortener(UrlShortenerDTO urlShortenerDTO) {
        
        if(urlShortenerDTO == null){
            throw new UrlShortenerException(URL_NOT_CREATED);
        }

        UrlShortener urlShortener = urlMapper.toDAO(urlShortenerDTO);

        return Response.ok(
             urlService.createUrlShortener(urlShortener)
                    .stream()
                    .map(url -> urlMapper.toDTO(url))
                    .collect(Collectors.toList())
            ).build();
    }
    
}
