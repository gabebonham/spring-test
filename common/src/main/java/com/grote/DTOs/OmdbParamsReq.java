package com.grote.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmdbParamsReq {
    private String s;
    private String type;
    private String y;
    private Integer page;
    private String i;
    private String t;
}
