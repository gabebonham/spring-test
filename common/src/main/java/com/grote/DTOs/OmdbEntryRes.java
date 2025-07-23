package com.grote.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmdbEntryRes {
    private String Title;
    private Integer Year;
    private String imdbID;
    private String Type;
    private String Poster;
}
