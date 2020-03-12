package com.example.flixster.modules;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdroppath;
    String posterpath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {

        backdroppath=jsonObject.getString("backdrop_path");
        posterpath= jsonObject.getString( "poster_path") ;
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(JSONArray moviejsonArray) throws JSONException {
        List<Movie> movies =new ArrayList<>();
        for(int i = 0; i< moviejsonArray.length(); i++){
            movies.add(new Movie(moviejsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterpath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterpath) ;
    }
    public String getBackdroppath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdroppath) ;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
