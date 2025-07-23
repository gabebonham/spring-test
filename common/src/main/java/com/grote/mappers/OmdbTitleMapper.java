package com.grote.mappers;

import com.grote.DTOs.OmdbTitleIntegration;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.DTOs.RatingIntegration;
import com.grote.DTOs.RatingRes;
import com.grote.models.OmdbTitle;
import com.grote.models.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class OmdbTitleMapper {
    public static OmdbTitle mapToModel(OmdbTitleIntegration integration){
        if (integration == null) return null;
        return OmdbTitle.builder()
                .Title(integration.getTitle())
                .Year(integration.getYear())
                .Rated(integration.getRated())
                .Released(integration.getReleased())
                .Runtime(integration.getRuntime())
                .Genre(integration.getGenre())
                .Director(integration.getDirector())
                .Writer(integration.getWriter())
                .Actors(integration.getActors())
                .Plot(integration.getPlot())
                .Language(integration.getLanguage())
                .Country(integration.getCountry())
                .Awards(integration.getAwards())
                .Poster(integration.getPoster())
                .Ratings(mapRatings(integration.getRatings()))
                .Metascore(integration.getMetascore())
                .imdbRating(integration.getImdbRating())
                .imdbVotes(integration.getImdbVotes())
                .imdbID(integration.getImdbID())
                .Type(integration.getType())
                .DVD(integration.getDVD())
                .BoxOffice(integration.getBoxOffice())
                .Production(integration.getProduction())
                .build();
    }
    public static OmdbTitleRes mapToRes(OmdbTitle model){
        if (model == null) return null;
        return OmdbTitleRes.builder()
                .Title(model.getTitle())
                .Year(model.getYear())
                .Rated(model.getRated())
                .Released(model.getReleased())
                .Runtime(model.getRuntime())
                .Genre(model.getGenre())
                .Director(model.getDirector())
                .Writer(model.getWriter())
                .Actors(model.getActors())
                .Plot(model.getPlot())
                .Language(model.getLanguage())
                .Country(model.getCountry())
                .Awards(model.getAwards())
                .Poster(model.getPoster())
                .Ratings(mapRatingsRes(model.getRatings()))
                .Metascore(model.getMetascore())
                .imdbRating(model.getImdbRating())
                .imdbVotes(model.getImdbVotes())
                .imdbID(model.getImdbID())
                .Type(model.getType())
                .DVD(model.getDVD())
                .BoxOffice(model.getBoxOffice())
                .Production(model.getProduction())
                .build();
    }
    private static List<RatingRes> mapRatingsRes(List<Rating> ratings) {
        if (ratings == null) return null;
        return ratings.stream()
                .map(r -> RatingRes.builder()
                        .Source(r.getSource())
                        .Value(r.getValue())
                        .build())
                .collect(Collectors.toList());
    }
    private static List<Rating> mapRatings(List<RatingIntegration> ratings) {
        if (ratings == null) return null;
        return ratings.stream()
                .map(r -> Rating.builder()
                        .Source(r.getSource())
                        .Value(r.getValue())
                        .build())
                .collect(Collectors.toList());
    }
}
