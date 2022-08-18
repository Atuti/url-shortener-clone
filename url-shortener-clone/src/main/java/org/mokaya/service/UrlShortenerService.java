package org.mokaya.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mokaya.entity.UrlShortener;
import org.mokaya.exception.UrlShortenerException;
import org.mokaya.entity.UrlShortenerRepository;;

@Singleton
public class UrlShortenerService {

    @ConfigProperty(name = "exception.message.url_not_created")
    public String URL_NOT_CREATED;

    @ConfigProperty(name = "exception.message.alias_already_exists")
    public String ALIAS_ALREADY_EXIST;

    @ConfigProperty(name = "exception.message.alias_null")
    public String ALIAS_NULL;

    @Inject
    UrlShortenerRepository urlRepository;

    @Transactional
    public List<UrlShortener> createUrlShortener(UrlShortener urlShortener){
        
        if(urlShortener == null){
            throw new UrlShortenerException(URL_NOT_CREATED);
        }

        long alias = urlRepository.find("alias", urlShortener.getAlias()).count();

        if (alias > 0){
            throw new UrlShortenerException(ALIAS_ALREADY_EXIST);
        }

        urlRepository.persist(urlShortener);

        return urlRepository.listAll();
    }

    public Optional<UrlShortener> getUrlShortener(String alias){

        if(alias == null || alias.isBlank()){
            throw new UrlShortenerException(ALIAS_NULL);
        }

        return urlRepository.find("alias", alias).firstResultOptional(); //.stream().findFirst()
    }
}
