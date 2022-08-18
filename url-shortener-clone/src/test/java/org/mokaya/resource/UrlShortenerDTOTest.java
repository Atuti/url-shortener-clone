package org.mokaya.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UrlShortenerDTOTest {
    private UrlShortenerDTO urlShortenerDTO;

    @BeforeEach
    void setUp() throws URISyntaxException{
        urlShortenerDTO = new UrlShortenerDTO("alias", new URI("http://myurl"));
    }

    @Test
    void urlShortenerNotNull(){
        assertNotNull(urlShortenerDTO);
    }

    @Test
    void testGetAlias() {
        assertEquals("alias", urlShortenerDTO.getAlias());
    }

    @Test
    void testGetUrl() {
        assertEquals("http://myurl", urlShortenerDTO.getUrl().toString());
    }

    @Test
    void testSetAlias() {
        urlShortenerDTO.setAlias("newAlias");
        assertEquals("newAlias", urlShortenerDTO.getAlias());
    }

    @Test
    void testSetUrl() throws URISyntaxException {
        urlShortenerDTO.setUrl(new URI("http://mynewurl"));
        assertEquals("http://mynewurl", urlShortenerDTO.getUrl().toString());
    }
}
