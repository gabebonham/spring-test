package com.grote.impl.omdb.services;

import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.integration.omdb.services.OmdbIntegrationService;
import com.grote.mappers.OmdbParamsMapper;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.mappers.OmdbTitleMapper;
import com.grote.models.OmdbParams;
import com.grote.models.OmdbSearch;
import com.grote.models.OmdbTitle;
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
class OmdbServiceTest {

    @Mock
    private OmdbIntegrationService integrationService;

    @InjectMocks
    private OmdbService omdbService;

    @Test
    void testGetSearch() {
        OmdbParams params = new OmdbParams();
        OmdbParamsIntegration integrationParams = new OmdbParamsIntegration();
        OmdbSearch search = new OmdbSearch();
        OmdbSearchRes expectedRes = new OmdbSearchRes();

        try (MockedStatic<OmdbParamsMapper> mockParamsMapper = Mockito.mockStatic(OmdbParamsMapper.class);
             MockedStatic<OmdbSearchMapper> mockSearchMapper = Mockito.mockStatic(OmdbSearchMapper.class)) {

            mockParamsMapper.when(() -> OmdbParamsMapper.mapToIntegration(params)).thenReturn(integrationParams);
            mockSearchMapper.when(() -> OmdbSearchMapper.mapToRes(search)).thenReturn(expectedRes);

            when(integrationService.getSearch(integrationParams)).thenReturn(search);

            OmdbSearchRes result = omdbService.getSearch(params);
            assertEquals(expectedRes, result);
        }
    }

    @Test
    void testGetTitle() {
        OmdbParams params = new OmdbParams();
        OmdbParamsIntegration integrationParams = new OmdbParamsIntegration();
        OmdbTitle title = new OmdbTitle();
        OmdbTitleRes expectedRes = new OmdbTitleRes();

        try (MockedStatic<OmdbParamsMapper> mockParamsMapper = Mockito.mockStatic(OmdbParamsMapper.class);
             MockedStatic<OmdbTitleMapper> mockTitleMapper = Mockito.mockStatic(OmdbTitleMapper.class)) {

            mockParamsMapper.when(() -> OmdbParamsMapper.mapToIntegration(params)).thenReturn(integrationParams);
            mockTitleMapper.when(() -> OmdbTitleMapper.mapToRes(title)).thenReturn(expectedRes);

            when(integrationService.getTitle(integrationParams)).thenReturn(title);

            OmdbTitleRes result = omdbService.getTitle(params);
            assertEquals(expectedRes, result);
        }
    }
}
