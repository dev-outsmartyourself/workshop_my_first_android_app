package com.outsmart.starwarsfilms.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.outsmart.starwarsfilms.Adapters.FilmsAdapter;
import com.outsmart.starwarsfilms.DataSources.FilmMockDataSource;
import com.outsmart.starwarsfilms.Models.FilmModel;
import com.outsmart.starwarsfilms.R;

import io.reactivex.Observer;

public class FilmsList extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FilmMockDataSource dataSource = FilmMockDataSource.getInstance();
    private Observer<FilmModel> filmsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.films_recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FilmsAdapter(dataSource.getAllFilms());
        mRecyclerView.setAdapter(mAdapter);
    }
}
