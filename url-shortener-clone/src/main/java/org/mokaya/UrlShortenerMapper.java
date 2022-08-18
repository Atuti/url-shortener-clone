package org.mokaya;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mokaya.entity.UrlShortener;
import org.mokaya.resource.UrlShortenerDTO;

@Mapper(
    componentModel = "cdi",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UrlShortenerMapper {
    
    UrlShortener toDAO(UrlShortenerDTO dto);

    UrlShortenerDTO toDTO(UrlShortener dao);
}
