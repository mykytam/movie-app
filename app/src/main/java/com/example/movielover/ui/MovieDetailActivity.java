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
    private TextView movie_title, movie_desc, rating, ratingI, ratingR, ratingM;
    private TextView Myear, Mgenre, Mruntime;
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
        String ratImdb = getIntent().getExtras().getString("ratingIMDB");
        String ratRotten = getIntent().getExtras().getString("ratingROTTEN");
        String ratMeta = getIntent().getExtras().getString("ratingMETA");

        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageСover = getIntent().getExtras().getInt("imgCover");

        String movieYear = getIntent().getExtras().getString("year");
        String movieGenre = getIntent().getExtras().getString("genre");
        String movieRuntime = getIntent().getExtras().getString("runtime");


        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);

        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageСover).into(MovieCoverImg);

        movie_title = findViewById(R.id.detail_movie_title);
        movie_title.setText(movieTitle);

        ratingI = findViewById(R.id.movie_detail_rating_imdb);
        ratingI.setText(ratImdb);

        ratingR = findViewById(R.id.movie_detail_rating_rt);
        ratingR.setText(ratRotten);

        ratingM = findViewById(R.id.movie_detail_rating_mc);
        ratingM.setText(ratMeta);

        Myear = findViewById(R.id.movie_detail_year);
        Myear.setText(movieYear);

        movie_desc = findViewById(R.id.detail_movie_desc);
        movie_desc.setText(movieDesc);

        Mgenre = findViewById(R.id.movie_detail_genre);
        Mgenre.setText(movieGenre);

        Mruntime = findViewById(R.id.movie_detail_runtime);
        Mruntime.setText(movieRuntime);

        //animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }
}
