package com.grote.mappers;

import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.models.OmdbSearch;

public class OmdbSearchMapper {
    public static OmdbSearch mapToModel(OmdbSearchIntegration integration){
        var entities = integration.getSearch().stream()
                .map(OmdbEntryMapper::mapToModel)
                .toList();
        return OmdbSearch.builder()
                .Search(entities)
                .build();
    }
    public static OmdbSearchRes mapToRes(OmdbSearch model){
        var entities = model.getSearch().stream()
                .map(OmdbEntryMapper::mapToRes)
                .toList();
        return OmdbSearchRes.builder()
                .Search(entities)
                .build();
    }
}
