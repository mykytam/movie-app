package com.example.movielover.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movielover.models.Movie;
import com.example.movielover.adapters.MovieAdapter;
import com.example.movielover.adapters.MovieItemClickListener;
import com.example.movielover.R;
import com.example.movielover.models.Slide;
import com.example.movielover.adapters.SliderPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView moviesResView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        moviesResView = findViewById(R.id.Rv_movies);

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

        // Recyclerview Setup
        // ini data
        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("Birds Of Prey", R.drawable.harley,R.drawable.harleycover ));
        listMovies.add(new Movie("Mulan", R.drawable.mulan,R.drawable.mulancover));
        listMovies.add(new Movie("Fast & Furious 9", R.drawable.fast9, R.drawable.fast9cover));
        listMovies.add(new Movie("No Time To Die", R.drawable.bond, R.drawable.bondcover));
        listMovies.add(new Movie("Black Widow", R.drawable.black, R.drawable.blackcover));

        MovieAdapter movieAdapter = new MovieAdapter(this, listMovies, this);
        moviesResView.setAdapter(movieAdapter);
        moviesResView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        //sending movie info to detail activity, transition animation between two activities
        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie info to detailActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPicture());
        // creation of the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

        Toast.makeText(this,"item clicked : " + movie.getTitle(), Toast.LENGTH_LONG).show();


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
