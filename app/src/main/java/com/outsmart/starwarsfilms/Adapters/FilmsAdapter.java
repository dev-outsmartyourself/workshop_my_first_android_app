package com.outsmart.starwarsfilms.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.outsmart.starwarsfilms.Models.FilmModel;
import com.outsmart.starwarsfilms.R;
import com.outsmart.starwarsfilms.Utils.DownloadImageTask;

import java.util.List;

/**
 * Created by lucas on 21/09/17.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private List<FilmModel> films;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    public FilmsAdapter(List<FilmModel> films) {
        this.films = films;
    }

    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView title = (TextView) holder.view.findViewById(R.id.episode_title);
        ImageView image = (ImageView) holder.view.findViewById(R.id.episode_image);
        TextView year = (TextView) holder.view.findViewById(R.id.episode_year);
        TextView episodeNumber = (TextView) holder.view.findViewById(R.id.episode_number);
        TextView imdbRate = (TextView) holder.view.findViewById(R.id.episode_imdb);

        DownloadImageTask task = new DownloadImageTask(image);
        task.execute(this.films.get(position).getImage());
        title.setText(this.films.get(position).getTitle());
        year.setText(String.valueOf(this.films.get(position).getEpisodeYear()));
        episodeNumber.setText("Episode " + this.films.get(position).getEpisodeNumber());
        imdbRate.setText(this.films.get(position).getImdbRate() + "/10");
    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
