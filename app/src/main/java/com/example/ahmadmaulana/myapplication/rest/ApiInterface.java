package com.example.ahmadmaulana.myapplication.rest;

import com.example.ahmadmaulana.myapplication.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ahmad Maulana on 1/22/2019.
 */
public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(
            @Query("api_key") String apikey
    );

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlaying(
            @Query("api_key") String apikey
    );

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcoming(
            @Query("api_key") String apikey
    );


    @GET("movie/{id}")
    Call<MovieResponse> getDetailMovies(@Path("id") int id, @Query("api_key") String apikey);
}
