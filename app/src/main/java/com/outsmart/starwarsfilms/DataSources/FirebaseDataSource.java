package com.outsmart.starwarsfilms.DataSources;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.outsmart.starwarsfilms.Models.FilmModel;

import java.util.List;

/**
 * Created by lucas on 21/09/17.
 */

public class FirebaseDataSource {

    private static FirebaseDataSource instance = new FirebaseDataSource();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("films");

    public static FirebaseDataSource getInstance() {
        return instance;
    }

    public void getAllFilms(final GetAllFilmsListener listener, final List<FilmModel> films) {
        myRef.orderByChild("episodeNumber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                films.clear();
                for (DataSnapshot filmSnapshot : dataSnapshot.getChildren()) {
                    FilmModel film = parseSnapshot(filmSnapshot);
                    films.add(film);
                }
                listener.onDataRetrieved();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("", "Erro no firebase", error.toException());
            }
        });
    }

    public interface GetAllFilmsListener {
        public void onDataRetrieved();
    }

    public FilmModel parseSnapshot(DataSnapshot filmSnapshot) {
        String id = String.valueOf(filmSnapshot.child("id").getValue());
        String title = String.valueOf(filmSnapshot.child("title").getValue());
        int episodeNumber = ((Long) filmSnapshot.child("episodeNumber").getValue()).intValue();
        int episodeYear = ((Long) filmSnapshot.child("episodeYear").getValue()).intValue();
        String image = String.valueOf(filmSnapshot.child("image").getValue());
        double imdbRate = (double) filmSnapshot.child("imdbRate").getValue();
        return new FilmModel(id, title, image, episodeNumber, episodeYear, imdbRate);
    }
}
