package com.grote.mappers;

import com.grote.DTOs.OmdbEntryIntegration;
import com.grote.DTOs.OmdbEntryRes;
import com.grote.models.OmdbEntry;

public class OmdbEntryMapper {
    public static OmdbEntry mapToModel(OmdbEntryIntegration integration){
        if (integration == null) return null;
        return OmdbEntry.builder()
                .Title(integration.getTitle())
                .Year(integration.getYear())
                .Type(integration.getType())
                .imdbID(integration.getImdbID())
                .Poster(integration.getPoster())
                .build();
    }
    public static OmdbEntryRes mapToRes(OmdbEntry model){
        if (model == null) return null;
        return OmdbEntryRes.builder()
                .Title(model.getTitle())
                .Year(model.getYear())
                .Type(model.getType())
                .imdbID(model.getImdbID())
                .Poster(model.getPoster())
                .build();
    }
}
