package org.mokaya.resource;

import java.net.URI;

public class UrlShortenerDTO {

    private String alias;

    private URI url;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public UrlShortenerDTO(String alias, URI url) {
        this.alias = alias;
        this.url = url;
    }

    public UrlShortenerDTO() {
    }
}
