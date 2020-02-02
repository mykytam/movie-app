package com.example.movielover.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movielover.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView movie_title, movie_desc, rating;
    private FloatingActionButton play_fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // ini views
        iniViews();
    }

    void iniViews() {
        // get the data
        play_fab = findViewById(R.id.play_fab);
        String url = getIntent().getExtras().getString("trailerURL");
        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        String movieTitle = getIntent().getExtras().getString("title");
        String movieDesc = getIntent().getExtras().getString("desc");
        String rat = getIntent().getExtras().getString("rating");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageСover = getIntent().getExtras().getInt("imgCover");

        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);

        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageСover).into(MovieCoverImg);

        movie_title = findViewById(R.id.detail_movie_title);
        movie_title.setText(movieTitle);


        movie_desc = findViewById(R.id.detail_movie_desc);
        movie_desc.setText(movieDesc);
        rating = findViewById(R.id.detail_movie_rating);
        rating.setText(rat);
        //animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));


    }
}
