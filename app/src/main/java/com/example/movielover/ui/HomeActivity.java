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

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        moviesResView = findViewById(R.id.Rv_movies);

        // prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "1917"));
        lstSlides.add(new Slide(R.drawable.slide2, "The Irishman"));
        lstSlides.add(new Slide(R.drawable.slide3, "Little Women"));
        lstSlides.add(new Slide(R.drawable.slide4, "The Two Popes"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderpager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);

        // Recyclerview Setup
        // ini data
        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("Birds Of Prey","After splitting with the Joker, Harley Quinn joins superheroes Black Canary, Huntress and Renee Montoya to save a young girl from an evil crime lord." ,  R.drawable.harley,"IMDb ✰ 8.9",R.drawable.harleycover ));
        listMovies.add(new Movie("Mulan","A young Chinese maiden disguises herself as a male warrior in order to save her father. A live-action feature film based on Disney's 'Mulan.'", R.drawable.mulan, "IMDb ✰ 7.0",R.drawable.mulancover));
        listMovies.add(new Movie("Fast & Furious 9", "When a mysterious woman seduces Dominic Toretto (Vin Diesel) into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.",R.drawable.f9, "IMDb ✰ 5.6",R.drawable.fast9cover));
        listMovies.add(new Movie("No Time To Die", "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.", R.drawable.bond, "IMDb ✰ 8.4",R.drawable.bondcover));
        listMovies.add(new Movie("Black Widow","A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.", R.drawable.black_widow, "IMDb ✰ 7.3",R.drawable.black_widow_cover));
        listMovies.add(new Movie("Marriage Story","Noah Baumbach's incisive and compassionate look at a marriage breaking up and a family staying together.", R.drawable.history, "IMDb ✰ 8.1",R.drawable.historycover));

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
        intent.putExtra("desc", movie.getDescription());
        intent.putExtra("rating", movie.getRating());
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
