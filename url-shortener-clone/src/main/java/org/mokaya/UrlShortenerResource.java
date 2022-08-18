package org.mokaya;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class UrlShortenerResource implements UriShortenerApi{

    @Inject
    UrlShortenerService urlShortenerService;

    @Override
    public Response getUrlShortener(String alias) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response createUrlShortener(UrlShortenerDTO urlShortenerDTO) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
