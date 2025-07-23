package com.grote.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmdbEntry {
    private String Title;
    private Integer Year;
    private String imdbID;
    private String Type;
    private String Poster;
}
