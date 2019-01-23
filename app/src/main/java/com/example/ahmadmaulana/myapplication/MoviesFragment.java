package com.example.ahmadmaulana.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmadmaulana.myapplication.adapter.MoviesAdapter;
import com.example.ahmadmaulana.myapplication.model.Movie;
import com.example.ahmadmaulana.myapplication.model.MovieResponse;
import com.example.ahmadmaulana.myapplication.rest.ApiClient;
import com.example.ahmadmaulana.myapplication.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmad Maulana on 1/22/2019.
 */
public class MoviesFragment extends Fragment {
    private ActionBar actionBar;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final String TAG = MoviesFragment.class.getSimpleName();
    private final static String API_KEY = "43954c2d8a99381ff77508aeaa6d3a1a";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (API_KEY.isEmpty()){
            Toast.makeText(getContext(), "API KEY tidak ada!", Toast.LENGTH_SHORT).show();
        }
        final View view = inflater.inflate(R.layout.fragment_movies, container, false);

        Typeface sfProBold = ResourcesCompat.getFont(getActivity(), R.font.bold);
        Typeface sfProRegular = ResourcesCompat.getFont(getActivity(), R.font.regular);
        Typeface sfProSemi = ResourcesCompat.getFont(getActivity(), R.font.semibold);




//        Recylerview
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.popular_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        final RecyclerView now_playing = (RecyclerView) view.findViewById(R.id.now_playing);
        now_playing.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        final RecyclerView upcoming = (RecyclerView) view.findViewById(R.id.upcoming_movies);
        upcoming.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.popular_movie_item, getActivity()));

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

        Call<MovieResponse> nowPlaying = apiService.getNowPlaying(API_KEY);
        nowPlaying.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int responCode = response.code();
                List<Movie> np = response.body().getResults();
                now_playing.setAdapter(new MoviesAdapter(np, R.layout.popular_movie_item, getActivity()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

        Call<MovieResponse> upcomingMovie = apiService.getUpcoming(API_KEY);
        upcomingMovie.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int responCode = response.code();
                List<Movie> np = response.body().getResults();
                upcoming.setAdapter(new MoviesAdapter(np, R.layout.upcoming_item, getActivity()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
//        nowPlaying.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                int statusCode = response.code();
//                List<Movie> movies = response.body().getResults();
//                mPager.setAdapter(new SliderAdapter(movies, getContext()));
//
////                CirclePageIndicator indicator = (CirclePageIndicator)
////                        view.findViewById(R.id.indicator);
//
////                indicator.setViewPager(mPager);
//
//                final float density = getResources().getDisplayMetrics().density;
//
//
////                indicator.setRadius(5 * density);
//
//                NUM_PAGES = movies.size();
//
//                // Auto start of viewpager
//                final Handler handler = new Handler();
//                final Runnable Update = new Runnable() {
//                    public void run() {
//                        if (currentPage == NUM_PAGES) {
//                            currentPage = 0;
//                        }
//                        mPager.setCurrentItem(currentPage++, true);
//                    }
//                };
//
//                Timer swipeTimer = new Timer();
//                swipeTimer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        handler.post(Update);
//                    }
//                }, 3000, 3000);
////
////                // Pager listener over indicator
////                indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
////
////                    @Override
////                    public void onPageSelected(int position) {
////                        currentPage = position;
////
////                    }
////
////                    @Override
////                    public void onPageScrolled(int pos, float arg1, int arg2) {
////
////                    }
////
////                    @Override
////                    public void onPageScrollStateChanged(int pos) {
////
////                    }
////                });
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
