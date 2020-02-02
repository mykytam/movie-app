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

public class HomeScreenTrailer extends AppCompatActivity  {

    private FloatingActionButton play_trailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_item);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // ini views
        iniViews();
    }

    void iniViews() {
        // get the data
        play_trailer = findViewById(R.id.play_fab);
        String url = getIntent().getExtras().getString("trailerURL");
        play_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });


        play_trailer.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));


    }
}
