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

public class FilmsActivity extends Activity implements FirebaseDataSource.GetAllFilmsListener {

    private FirebaseDataSource dataSource = FirebaseDataSource.getInstance();
    private FilmsAdapter adapter;
    private List<FilmModel> films = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.films_list);

        dataSource.getAllFilms(this, films);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.films_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        adapter = new FilmsAdapter(films);
        recycler.setAdapter(adapter);


    }

    @Override
    public void onDataRetrieved() {
        adapter.notifyDataSetChanged();
    }
}
