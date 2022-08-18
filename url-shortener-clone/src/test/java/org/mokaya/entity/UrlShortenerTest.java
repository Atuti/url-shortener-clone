package org.mokaya.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UrlShortenerTest {

    private UrlShortener urlShortener;

    @BeforeEach
    void setUp() throws URISyntaxException{
        urlShortener = new UrlShortener("alias", new URI("http://myurl"));
    }

    @Test
    void urlShortenerNotNull(){
        assertNotNull(urlShortener);
    }

    @Test
    void testGetAlias() {
        assertEquals("alias", urlShortener.getAlias());
    }

    @Test
    void testGetUrl() {
        assertEquals("http://myurl", urlShortener.getUrl().toString());
    }

    @Test
    void testSetAlias() {
        urlShortener.setAlias("newAlias");
        assertEquals("newAlias", urlShortener.getAlias());
    }

    @Test
    void testSetUrl() throws URISyntaxException {
        urlShortener.setUrl(new URI("http://mynewurl"));
        assertEquals("http://mynewurl", urlShortener.getUrl().toString());
    }
}
