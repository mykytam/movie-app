package com.example.movielover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);

        // prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "1917 \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide2, "The Irishman \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide3, "Knives Out \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide4, "The Two Popes \nOfficial Trailer"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);

        sliderpager.setAdapter(adapter);
    }

}
