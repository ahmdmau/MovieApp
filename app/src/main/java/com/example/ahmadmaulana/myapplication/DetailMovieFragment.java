package com.example.ahmadmaulana.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmadmaulana.myapplication.model.Movie;
import com.example.ahmadmaulana.myapplication.model.MovieResponse;
import com.example.ahmadmaulana.myapplication.rest.ApiClient;
import com.example.ahmadmaulana.myapplication.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmad Maulana on 1/23/2019.
 */
public class DetailMovieFragment extends Fragment {

    private final static String API_KEY = "43954c2d8a99381ff77508aeaa6d3a1a";
//    private ArrayList<Movie> movies;
    Movie movie;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail_movies, container, false);
//        Bundle mBundle = new Bundle();
//        mBundle = getArguments();
//        mBundle.getSerializable("data");
//        movie = (Movie) mBundle.getSerializable("data");
//        movies = (ArrayList<Movie>)getArguments().getSerializable("data");

        movie = (Movie) getArguments().getSerializable("data");

        TextView id_movie = (TextView) view.findViewById(R.id.id_movies);
        id_movie.setText(movie.getId().toString());

//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<MovieResponse> call = apiService.getDetailMovies(movie.getId(), API_KEY);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                Toast.makeText(getActivity(), "YES", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//
//            }
//        });

        return view;
    }
}
