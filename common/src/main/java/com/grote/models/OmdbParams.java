package com.grote.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmdbParams {
    private String s;
    private String type;
    private String y;
    private Integer page;
}
