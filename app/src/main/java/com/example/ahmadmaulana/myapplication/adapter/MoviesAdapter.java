package com.example.ahmadmaulana.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ahmadmaulana.myapplication.R;
import com.example.ahmadmaulana.myapplication.model.Movie;

import java.util.List;

/**
 * Created by Ahmad Maulana on 1/22/2019.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView poster_img;
        TextView title_movie, release_date, genre_movie,rating_movie,language;
        RatingBar ratingBar;

        public MovieViewHolder(View v) {
            super(v);
            poster_img = (ImageView) v.findViewById(R.id.poster_img);
            title_movie = (TextView) v.findViewById(R.id.title_movie);
//            genre_movie = (TextView) v.findViewById(R.id.genre);
            rating_movie = (TextView) v.findViewById(R.id.rating);
//            release_date = (TextView) v.findViewById(R.id.release_date);
//            language = (TextView) v.findViewById(R.id.language);
            ratingBar = (RatingBar) v.findViewById(R.id.star_rating);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath())
                .into(holder.poster_img);
        String vote = String.valueOf(movies.get(position).getVoteAverage());
        float star = Float.parseFloat(vote);
        String adult;

//        if (movies.get(position).isAdult() == true)
//        {
//            adult = "Adult";
//        }
//        else {
//            adult = "For Everyone";
//        }


        holder.title_movie.setText(movies.get(position).getTitle());
        holder.rating_movie.setText(movies.get(position).getVoteAverage().toString());
//        holder.language.setText(adult);
//        holder.release_date.setText(movies.get(position).getReleaseDate().toString());
        holder.ratingBar.setRating(star);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.title_movie.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
//        holder.genre_movie.setText(movies.get(position).getVoteCount().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
