package com.grote.controller.omdb.facaes;

import com.grote.DTOs.OmdbParamsReq;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.impl.omdb.services.OmdbService;
import com.grote.mappers.OmdbParamsMapper;
import com.grote.models.OmdbParams;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class OmdbControllerFacadeTest {

    @Mock
    private OmdbService service;

    @InjectMocks
    private OmdbControllerFacade facade;

    @Test
    void testGetSearch() {
        OmdbParamsReq req = new OmdbParamsReq();
        OmdbSearchRes expected = new OmdbSearchRes();
        OmdbParams mappedParams = new OmdbParams();

        try (MockedStatic<OmdbParamsMapper> mockedStatic = Mockito.mockStatic(OmdbParamsMapper.class)) {
            mockedStatic.when(() -> OmdbParamsMapper.mapToModel(req)).thenReturn(mappedParams);

            when(service.getSearch(mappedParams)).thenReturn(expected);
            OmdbSearchRes result = facade.getSearch(req);

            assertEquals(expected, result);
        }
    }

    @Test
    void testGetTitle() {
        OmdbParamsReq req = new OmdbParamsReq();
        OmdbTitleRes expected = new OmdbTitleRes();
        OmdbParams mappedParams = new OmdbParams();

        try (MockedStatic<OmdbParamsMapper> mockedStatic = Mockito.mockStatic(OmdbParamsMapper.class)) {
            mockedStatic.when(() -> OmdbParamsMapper.mapToModel(req)).thenReturn(mappedParams);

            when(service.getTitle(mappedParams)).thenReturn(expected);
            OmdbTitleRes result = facade.getTitle(req);

            assertEquals(expected, result);
        }
    }
}
