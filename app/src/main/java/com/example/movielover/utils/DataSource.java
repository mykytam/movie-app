package com.example.movielover.utils;

import com.example.movielover.R;
import com.example.movielover.models.Movie;
import com.example.movielover.models.Slide;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Movie> getNewMovies() {

        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("Birds Of Prey","After splitting with the Joker, Harley Quinn joins superheroes Black Canary, Huntress and Renee Montoya to save a young girl from an evil crime lord." ,  R.drawable.harley,"8.9", "", "", R.drawable.harleycover, "https://www.youtube.com/watch?v=x3HbbzHK5Mc", "Action, Adventure, Crime", "(2020)", "1h 49min" ));
        listMovies.add(new Movie("Mulan","A young Chinese maiden disguises herself as a male warrior in order to save her father. A live-action feature film based on Disney's 'Mulan.'", R.drawable.mulan, "7.0", "", "",R.drawable.mulancover, "https://www.youtube.com/watch?v=KK8FHdFluOQ", "Action, Adventure, Drama", "(2020)", "NA" ));
        listMovies.add(new Movie("Fast & Furious 9", "When a mysterious woman seduces Dominic Toretto (Vin Diesel) into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.",R.drawable.f9, "5.6","", "",R.drawable.fast9cover, "https://www.youtube.com/watch?v=n3ZGo3A5t6s", "Action, Adventure, Crime", "(2020)", "2h 15min " ));
        listMovies.add(new Movie("No Time To Die", "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.", R.drawable.bond, "8.4","", "",R.drawable.bondcover, "https://www.youtube.com/watch?v=BIhNsAtPbPI", "Action, Adventure, Thriller", "2020", "NA" ));
        listMovies.add(new Movie("Black Widow","A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.", R.drawable.black_widow, "7.3","", "",R.drawable.black_widow_cover, "https://www.youtube.com/watch?v=RxAtuMu_ph4", "Action, Adventure, Sci-Fi", "(2020)", "NA" ));
        listMovies.add(new Movie("Marriage Story","Noah Baumbach's incisive and compassionate look at a marriage breaking up and a family staying together.", R.drawable.history, "8.1","", "",R.drawable.historycover, "https://www.youtube.com/watch?v=BHi-a1n8t7M", "Comedy, Drama, Romance", "(2019)", "2h 17min" ));
        return listMovies;
    }

    public static List<Movie> getClassicsMovies() {
        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("The Godfather","The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son." ,  R.drawable.godfather,"9.2","", "",R.drawable.godfather_cover, "https://www.youtube.com/watch?v=sY1S34973zA", "Crime, Drama ", "(1972)", "2h 55min" ));
        listMovies.add(new Movie("Apocalypse Now","A U.S. Army officer serving in Vietnam is tasked with assassinating a renegade Special Forces Colonel who sees himself as a god.", R.drawable.apocalypse, "8.4","", "",R.drawable.apocalypsecover, "https://www.youtube.com/watch?v=9l-ViOOFH-s", "Drama, Mystery, War", "(1979)", "2h 27min" ));
        listMovies.add(new Movie("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",R.drawable.redemption, "9.3","", "",R.drawable.redemptioncover, "https://www.youtube.com/watch?v=6hB3S9bIaco", "Drama", "(1994)", "2h 22min" ));
        listMovies.add(new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", R.drawable.fiction, "8.9","", "",R.drawable.fictioncover, "https://www.youtube.com/watch?v=s7EdQ4FqbhY", "Crime, Drama", "(1994)", "2h 34min" ));
        listMovies.add(new Movie("Fight Club","An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.", R.drawable.club, "8.8","", "",R.drawable.clubcover, "https://www.youtube.com/watch?v=SUXWAEX2jlg", "Drama", "(1999)", "2h 19min" ));
        listMovies.add(new Movie("Forrest Gump","The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.", R.drawable.forrest, "8.8","", "",R.drawable.forrestcover, "https://www.youtube.com/watch?v=bLvqoHBptjg", "Drama, Romance", "(1994)", "2h 22min" ));
        return listMovies;

    }

    public static List<Slide> getSliderMovies() {
        List<Slide> lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "1917", "https://www.youtube.com/watch?v=gZjQROMAh_s"));
        lstSlides.add(new Slide(R.drawable.slide2, "The Irishman", "https://www.youtube.com/watch?v=WHXxVmeGQUc"));
        lstSlides.add(new Slide(R.drawable.slide3, "Little Women", "https://www.youtube.com/watch?v=AST2-4db4ic"));
        lstSlides.add(new Slide(R.drawable.slide4, "The Two Popes", "https://www.youtube.com/watch?v=T5OhkFY1PQE"));
        lstSlides.add(new Slide(R.drawable.slide5, "Once Upon a Time… in Hollywood", "https://www.youtube.com/watch?v=ELeMaP8EPAA"));
        return lstSlides;
    }


}
