package com.example.movielover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielover.R;
import com.example.movielover.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyviewHolder>{

    Context context ;
    List<Movie> movieData;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, List<Movie> movieData, MovieItemClickListener listener) {
        this.context = context;
        this.movieData = movieData;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.MovieTitle.setText(movieData.get(position).getTitle());
        holder.ImageMovie.setImageResource(movieData.get(position).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        private TextView MovieTitle;
        private ImageView ImageMovie;


        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            MovieTitle = itemView.findViewById(R.id.item_movie_title);
            ImageMovie = itemView.findViewById(R.id.item_movie_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMovieClick(movieData.get(getAdapterPosition()), ImageMovie);

                }
            }) ;



        }
    }
}
