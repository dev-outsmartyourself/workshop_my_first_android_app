package com.outsmart.starwarsfilms.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.outsmart.starwarsfilms.Adapters.FilmsAdapter;
import com.outsmart.starwarsfilms.DataSources.FirebaseDataSource;
import com.outsmart.starwarsfilms.Models.FilmModel;
import com.outsmart.starwarsfilms.R;

import java.util.ArrayList;
import java.util.List;

public class FilmsListActivity extends Activity implements FirebaseDataSource.GetAllFilmsListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseDataSource dataSource = FirebaseDataSource.getInstance();
    private List<FilmModel> films = new ArrayList<FilmModel>();
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

        mAdapter = new FilmsAdapter(films);
        mRecyclerView.setAdapter(mAdapter);
        dataSource.getAllFilms(this, this.films);

    }

    @Override
    public void onDataRetrieved() {
        mAdapter.notifyDataSetChanged();
    }
}
