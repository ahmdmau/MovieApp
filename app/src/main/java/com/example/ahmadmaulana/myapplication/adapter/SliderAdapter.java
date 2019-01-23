package com.example.ahmadmaulana.myapplication.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ahmadmaulana.myapplication.R;
import com.example.ahmadmaulana.myapplication.model.Movie;

import java.util.List;

/**
 * Created by Ahmad Maulana on 1/22/2019.
 */
public class SliderAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Movie> movies;

    public SliderAdapter(List<Movie> movies, Context context) {
        this.context = context;
        this.movies = movies;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slide_images, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);


        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movies.get(position).getBackdropPath())
                .into(imageView);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
