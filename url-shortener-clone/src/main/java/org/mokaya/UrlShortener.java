package org.mokaya;

import java.net.URI;

public class UrlShortener {
    private String alias;

    private URI url;

    public UrlShortener() {
    }

    public UrlShortener(String alias, URI url) {
        this.alias = alias;
        this.url = url;
    }

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

    
}