package com.grote.controller.omdb.controllers;

import com.grote.DTOs.OmdbSearchRes;
import com.grote.controller.omdb.facaes.OmdbControllerFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OmdbControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OmdbControllerFacade facade;

    @InjectMocks
    private OmdbController omdbController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(omdbController).build();
    }

    @Test
    void testGetSearch_success() throws Exception {
        OmdbSearchRes res = new OmdbSearchRes();
        when(facade.getSearch(any())).thenReturn(res);

        mockMvc.perform(post("/omdb/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"s\":\"Batman\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    void testGetTitle_error() throws Exception {
        when(facade.getTitle(any())).thenThrow(new RuntimeException("Test error"));

        mockMvc.perform(post("/omdb/title")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"t\":\"Inception\"}"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().string(containsString("Test error")));
    }
}