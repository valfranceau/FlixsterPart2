package com.example.flixster.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.modules.Movie;

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@ NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter","onCreateViewHolder");
       View movieview =  LayoutInflater.from(context).inflate(R.layout.idem_movie, parent, false) ;
    return new ViewHolder(movieview); }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter","onBindViewHolder" +position);
        Movie movie = movies.get(position) ;
        holder.bind(movie) ;

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itv;
        TextView itv2;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            itv = itemView.findViewById(R.id.itv);
             itv2 = itemView.findViewById(R.id.itv2);
              iv = itemView.findViewById(R.id.iv);
        }

        public void bind(Movie movie) {
            itv.setText(movie.getTitle());
            itv2.setText(movie.getOverview());
            String imageURL;
            if(context.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
            {
                imageURL=movie.getBackdroppath();
            }
            else
            {
                imageURL=movie.getPosterpath();
            }
            Glide.with(context).load(imageURL).into(iv);
        }
    }
}
