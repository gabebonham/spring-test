package com.grote.controller.omdb.controllers;

import com.grote.DTOs.OmdbParamsReq;
import com.grote.controller.omdb.facaes.OmdbControllerFacade;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/omdb")
@RequiredArgsConstructor
@Slf4j
public class OmdbController {
    private final OmdbControllerFacade facade;

    @PostMapping("/search")
    public ResponseEntity<?> getSearch(@RequestBody OmdbParamsReq req){
       try {
           String message = String.format("Request to /omdb/search with body: %s", req.toString());
           log.info(message);
           return ResponseEntity.ok(facade.getSearch(req));
       } catch (Exception e) {
           return ResponseEntity.unprocessableEntity().body(e.getMessage());
       }

    }
    @PostMapping("/title")
    public ResponseEntity<?> getTitle(@RequestBody OmdbParamsReq req){
       try {
           String message = String.format("Request to /omdb/title with body: %s", req.toString());
           log.info(message);
           return ResponseEntity.ok(facade.getTitle(req));
       } catch (Exception e) {
           return ResponseEntity.unprocessableEntity().body(e.getMessage());
       }

    }
}
