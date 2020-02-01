package com.example.movielover.utils;

import com.example.movielover.R;
import com.example.movielover.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Movie> getNewMovies() {

        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("Birds Of Prey","After splitting with the Joker, Harley Quinn joins superheroes Black Canary, Huntress and Renee Montoya to save a young girl from an evil crime lord." ,  R.drawable.harley,"IMDb ✰ 8.9",R.drawable.harleycover ));
        listMovies.add(new Movie("Mulan","A young Chinese maiden disguises herself as a male warrior in order to save her father. A live-action feature film based on Disney's 'Mulan.'", R.drawable.mulan, "IMDb ✰ 7.0",R.drawable.mulancover));
        listMovies.add(new Movie("Fast & Furious 9", "When a mysterious woman seduces Dominic Toretto (Vin Diesel) into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.",R.drawable.f9, "IMDb ✰ 5.6",R.drawable.fast9cover));
        listMovies.add(new Movie("No Time To Die", "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.", R.drawable.bond, "IMDb ✰ 8.4",R.drawable.bondcover));
        listMovies.add(new Movie("Black Widow","A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.", R.drawable.black_widow, "IMDb ✰ 7.3",R.drawable.black_widow_cover));
        listMovies.add(new Movie("Marriage Story","Noah Baumbach's incisive and compassionate look at a marriage breaking up and a family staying together.", R.drawable.history, "IMDb ✰ 8.1",R.drawable.historycover));
        return listMovies;
    }
}
