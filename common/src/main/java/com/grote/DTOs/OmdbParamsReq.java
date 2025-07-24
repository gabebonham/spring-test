package com.grote.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmdbParamsReq {
    @JsonProperty("s")
    private String s;
    @JsonProperty("t")
    private String t;
    @JsonProperty("type")
    private String type;
    @JsonProperty("y")
    private String y;
    @JsonProperty("page")
    private String page;
    @JsonProperty("i")
    private String i;
}

