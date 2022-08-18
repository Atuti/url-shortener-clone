package org.mokaya.entity;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UrlShortenerRepository implements PanacheRepository<UrlShortener>{

}
