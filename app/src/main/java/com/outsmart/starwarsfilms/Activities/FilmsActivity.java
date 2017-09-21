package com.outsmart.starwarsfilms.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.outsmart.starwarsfilms.DataSources.MockDataSource;
import com.outsmart.starwarsfilms.Models.FilmModel;
import com.outsmart.starwarsfilms.R;
import com.outsmart.starwarsfilms.Utils.DownloadImageTask;

import java.util.ArrayList;
import java.util.List;

public class FilmsActivity extends Activity  {

    private MockDataSource dataSource = MockDataSource.getInstance();
    private List<FilmModel> films = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_card);

        this.films = dataSource.getAllFilms();
        FilmModel film = this.films.get(0);

        TextView title = (TextView) findViewById(R.id.episode_title);
        ImageView image = (ImageView) findViewById(R.id.episode_image);
        TextView year = (TextView) findViewById(R.id.episode_year);
        TextView episodeNumber = (TextView) findViewById(R.id.episode_number);
        TextView imdbRate = (TextView) findViewById(R.id.episode_imdb);

        DownloadImageTask task = new DownloadImageTask(image);
        task.execute(film.getImage());
        title.setText(film.getTitle());
        year.setText(String.valueOf(film.getEpisodeYear()));
        episodeNumber.setText("Episode " + film.getEpisodeNumber());
        imdbRate.setText(film.getImdbRate() + "/10");
    }

}
