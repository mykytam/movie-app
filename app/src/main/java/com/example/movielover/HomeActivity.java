package com.example.movielover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

        // prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "1917 \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide2, "The Irishman \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide3, "Knives Out \nOfficial Trailer"));
        lstSlides.add(new Slide(R.drawable.slide4, "The Two Popes \nOfficial Trailer"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);

        sliderpager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);


        indicator.setupWithViewPager(sliderpager, true);
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    } else {
                        sliderpager.setCurrentItem(0);
                    }
                }
            });

        }
    }

}
