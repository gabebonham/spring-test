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
public class RatingIntegration {
    @JsonProperty("Source")
    private String Source;
    @JsonProperty("Value")
    private String Value;
}