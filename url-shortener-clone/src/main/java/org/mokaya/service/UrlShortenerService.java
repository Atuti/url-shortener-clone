package org.mokaya.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mokaya.entity.UrlShortener;
import org.mokaya.exception.UrlShortenerException;

@Singleton
public class UrlShortenerService {
    
    private List<UrlShortener> urlShortenerList = new ArrayList<>();

    @ConfigProperty(name = "exception.message.url_not_created")
    public String URL_NOT_CREATED;

    @ConfigProperty(name = "exception.message.alias_already_exists")
    public String ALIAS_ALREADY_EXIST;

    @ConfigProperty(name = "exception.message.alias_null")
    public String ALIAS_NULL;

    public List<UrlShortener> createUrlShortener(UrlShortener urlShortener){
        
        if(urlShortener == null){
            throw new UrlShortenerException(URL_NOT_CREATED);
        }

        long alias = urlShortenerList.stream()
        .filter(url -> url.getAlias().equals(urlShortener.getAlias())).count();

        if (alias > 0){
            throw new UrlShortenerException(ALIAS_ALREADY_EXIST);
        }

        urlShortenerList.add(urlShortener);

        return urlShortenerList;
    }

    public Optional<UrlShortener> getUrlShortener(String alias){

        if(alias == null || alias.isBlank()){
            throw new UrlShortenerException(ALIAS_NULL);
        }

        return urlShortenerList.stream()
        .filter(url -> url.getAlias().equals(alias)).findFirst();
    }
}
