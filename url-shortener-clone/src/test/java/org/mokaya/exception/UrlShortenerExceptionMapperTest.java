package org.mokaya.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UrlShortenerExceptionMapperTest {

    @Inject
    UrlShortenerExceptionMapper exceptionMapper;


    @Test
    void testToResponseAlreadyExists() {
        UrlShortenerException exception = new UrlShortenerException("The alias already exists.");
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        
        Response response = exceptionMapper.toResponse(exception);
        assertNotNull(response);
        assertEquals(Response.Status.CONFLICT, response.getStatusInfo());
    }

    @Test
    void testToResponseDefault() {
        UrlShortenerException exception = new UrlShortenerException(" ");
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        
        Response response = exceptionMapper.toResponse(exception);
        assertNotNull(response);
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
}
