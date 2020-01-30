package com.example.movielover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView moviePosterImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        // get the data
        String movieTitle = getIntent().getExtras().getString("title");
        int imagePosterId = getIntent().getExtras().getInt("imageURL");
        moviePosterImg = findViewById(R.id.item_movie_image);
        moviePosterImg.setImageResource(imagePosterId);

    }
}
