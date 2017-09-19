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
 * Created by lucas on 18/09/17.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private List<FilmModel> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FilmsAdapter(List<FilmModel> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_recycler_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView episodeTitle = (TextView) holder.mView.findViewById(R.id.film_recycler_item_episode_title);
        TextView episodeNumber = (TextView) holder.mView.findViewById(R.id.film_recycler_item_episode_number);
        TextView episodeYear = (TextView) holder.mView.findViewById(R.id.film_recycler_item_episode_year);
        TextView episodeImdb = (TextView) holder.mView.findViewById(R.id.film_recycler_item_episode_imdb);
        ImageView image = (ImageView) holder.mView.findViewById(R.id.film_recycler_item_episode_image);

        episodeTitle.setText(mDataset.get(position).getTitle());
        episodeNumber.setText("Episode " + mDataset.get(position).getEpisodeNumber());
        episodeYear.setText(String.valueOf(mDataset.get(position).getEpisodeYear()));
        episodeImdb.setText(mDataset.get(position).getImdbRate() + "/10");

        DownloadImageTask task = new DownloadImageTask(image);
        task.execute(mDataset.get(position).getImage());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
