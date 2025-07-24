package com.grote.controller.omdb.controllers;

import com.grote.DTOs.OmdbParamsReq;
import com.grote.controller.omdb.facaes.OmdbControllerFacade;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/omdb")
@RequiredArgsConstructor
public class OmdbController {
    private final OmdbControllerFacade facade;

    @PostMapping("/search")
    public ResponseEntity<?> getSearch(@RequestBody OmdbParamsReq req){
//        try {
//            return ResponseEntity.ok(facade.getSearch(req));
//        } catch (Exception e) {
//            return ResponseEntity.unprocessableEntity().body(e.getMessage());
//        }
        return ResponseEntity.ok(facade.getSearch(req));

    }
    @PostMapping("/title")
    public ResponseEntity<?> getTitle(@RequestBody OmdbParamsReq req){
//        try {
//            return ResponseEntity.ok(facade.getTitle(req));
//        } catch (Exception e) {
//            return ResponseEntity.unprocessableEntity().body(e.getMessage());
//        }
        return ResponseEntity.ok(facade.getTitle(req));

    }
}
