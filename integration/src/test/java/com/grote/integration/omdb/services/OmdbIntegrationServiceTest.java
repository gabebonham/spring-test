package com.grote.integration.omdb.services;

import com.grote.DTOs.OmdbEntryIntegration;
import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbTitleIntegration;
import com.grote.integration.omdb.config.EnvConfig;
import com.grote.integration.omdb.feign.OmdbFeign;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.mappers.OmdbTitleMapper;
import com.grote.models.OmdbSearch;
import com.grote.models.OmdbTitle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OmdbIntegrationServiceTest {

    @Mock
    private OmdbFeign feign;

    @Mock
    private EnvConfig env;

    @InjectMocks
    private OmdbIntegrationService integrationService;

    @Test
    void testGetSearch_success() {
        OmdbParamsIntegration params = new OmdbParamsIntegration();
        OmdbSearchIntegration integrationRes = new OmdbSearchIntegration();
        integrationRes.setSearch(List.of(new OmdbEntryIntegration()));

        when(env.getOmdbApiKey()).thenReturn("API_KEY");
        when(feign.getSearch("API_KEY", null, null, null, null)).thenReturn(integrationRes);
        Mockito.mockStatic(OmdbSearchMapper.class).when(() -> OmdbSearchMapper.mapToModel(integrationRes)).thenReturn(new OmdbSearch());

        OmdbSearch result = integrationService.getSearch(params);
        assertNotNull(result);
    }

    @Test
    void testGetTitle_success() {
        OmdbParamsIntegration params = new OmdbParamsIntegration();
        OmdbTitleIntegration integrationRes = new OmdbTitleIntegration();

        when(env.getOmdbApiKey()).thenReturn("API_KEY");
        when(feign.getTitle("API_KEY", null, null, null, null, "true", null)).thenReturn(integrationRes);
        Mockito.mockStatic(OmdbTitleMapper.class).when(() -> OmdbTitleMapper.mapToModel(integrationRes)).thenReturn(new OmdbTitle());

        OmdbTitle result = integrationService.getTitle(params);
        assertNotNull(result);
    }
}