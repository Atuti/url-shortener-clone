package org.mokaya.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.mokaya.service.UrlShortenerService;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

import org.mokaya.entity.UrlShortener;
import org.mokaya.exception.UrlShortenerException;

@QuarkusTest
public class UrlShortenerResourceTest {

    @Inject
    UrlShortenerResource urlShortenerResource;

    @InjectMock(convertScopes = true)
    UrlShortenerService urlShortenerService;

    @Test
    void testgetUrlShortenerFound() throws URISyntaxException {
        UrlShortener urlShortener = new UrlShortener("myAlias", new URI("https://myAlias.com"));

        when(urlShortenerService.getUrlShortener("myAlias")).thenReturn(Optional.of(urlShortener));

        assertNotNull(urlShortenerResource);

        Response response = urlShortenerResource.getUrlShortener("myAlias");
        assertNotNull(response);
        assertEquals(Response.Status.MOVED_PERMANENTLY, response.getStatusInfo());
        assertEquals("https://myAlias.com", response.getHeaderString("location"));
    }

    @Test
    void testgetUrlShortenerNotFound(){

        when(urlShortenerService.getUrlShortener("myAlias")).thenReturn(Optional.empty());

        assertNotNull(urlShortenerResource);

        Response response = urlShortenerResource.getUrlShortener("myalias");
        assertNotNull(response);
        assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
    }
    @Test
    void testCreateUrlShortenerNotFound() {
        assertThrows(UrlShortenerException.class, () -> urlShortenerResource.createUrlShortener(null));
    }

    @Test
    void createUrlShortener() throws URISyntaxException {
        UrlShortenerDTO dto = new UrlShortenerDTO("myAlias", new URI("https://myALias.com"));
        when(urlShortenerService.createUrlShortener(any())).thenReturn(new ArrayList<>());

        Response response  = urlShortenerResource.createUrlShortener(dto);
        assertNotNull(response);
        assertEquals(Response.Status.OK, response.getStatusInfo());
        assertNotNull(response.getEntity());

    }
}
