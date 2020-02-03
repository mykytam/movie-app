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
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.movielover.models.Movie;
import com.example.movielover.adapters.MovieAdapter;
import com.example.movielover.adapters.MovieItemClickListener;
import com.example.movielover.R;
import com.example.movielover.adapters.SliderPagerAdapter;
import com.example.movielover.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView moviesResView, moviesClassics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        iniViews();
        iniSlider();
        iniNewMovies();
        iniClassicsMovies();
    }

    private void iniClassicsMovies() {
        MovieAdapter classicMovieAdapter = new MovieAdapter(this, DataSource.getClassicsMovies(), this);
        moviesClassics.setAdapter(classicMovieAdapter);
        moviesClassics.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniNewMovies() {
        // Recyclerview Setup
        // ini data
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getNewMovies(), this);
        moviesResView.setAdapter(movieAdapter);
        moviesResView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        // prepare a list of slides
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, DataSource.getSliderMovies());
        sliderpager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        moviesResView = findViewById(R.id.Rv_movies);
        moviesClassics =findViewById(R.id.Rv_movies_classics);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        //sending movie info to detail activity, transition animation between two activities
        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie info to detailActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPicture());
        intent.putExtra("desc", movie.getDescription());
        intent.putExtra("ratingIMDB", movie.getRatingImdb());
        intent.putExtra("ratingROTTEN", movie.getRatingRotten());
        intent.putExtra("ratingMETA", movie.getRatingMeta());
        intent.putExtra("trailerURL", movie.getTrailerLink());
        intent.putExtra("year", movie.getYear());
        intent.putExtra("genre", movie.getGenre());
        intent.putExtra("runtime", movie.getRuntime());
        // creation of the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, movieImageView, "sharedName");
        startActivity(intent, options.toBundle());
    }




    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<DataSource.getSliderMovies().size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    } else {
                        sliderpager.setCurrentItem(0);
                    }
                }
            });

        }
    }

}
