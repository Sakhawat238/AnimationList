package com.buet13.sakhawat.animationworld;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> implements Filterable{
    private Context context;
    private List<Movie> moviesList;
    private List<Movie> moviesListFiltered;
    private ListAdapterListener listener;

    public MovieListAdapter(Context context,List<Movie> moviesList,ListAdapterListener listener) {
        this.context = context;
        this.moviesList = moviesList;
        this.moviesListFiltered = moviesList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, year,imdb_rat;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            year = v.findViewById(R.id.year);
            imdb_rat = v.findViewById(R.id.imdbrating);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMovieSelected(moviesListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Movie movie = moviesListFiltered.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText("year: "+movie.getMovie_year());
        holder.imdb_rat.setText("IMDB rating: "+movie.getImdb_rating());
    }

    @Override
    public int getItemCount() {
        return moviesListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) moviesListFiltered = moviesList;
                else{
                    List<Movie> filteredList = new ArrayList<>();
                    for(Movie row:moviesList){
                        if(row.getTitle().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row);
                        }
                    }
                    moviesListFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = moviesListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                moviesListFiltered = (ArrayList<Movie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ListAdapterListener{
        void onMovieSelected(Movie movie);
    }
}
