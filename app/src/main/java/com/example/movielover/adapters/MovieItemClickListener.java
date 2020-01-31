package com.example.movielover.adapters;

import android.widget.ImageView;

import com.example.movielover.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView );

}
