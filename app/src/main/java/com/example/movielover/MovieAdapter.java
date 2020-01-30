package com.example.movielover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyviewHolder>{

    Context context ;
    List<Movie> movieData;

    public MovieAdapter(Context context, List<Movie> movieData) {
        this.context = context;
        this.movieData = movieData;
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
        }
    }
}
