package com.outsmart.starwarsfilms.DataSources;

import com.outsmart.starwarsfilms.Models.FilmModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 21/09/17.
 */

public class MockDataSource {

    private static MockDataSource instance = new MockDataSource();
    private static List<FilmModel> films = new ArrayList<>();

    public static MockDataSource getInstance() {
        films.clear();
        films.add(new FilmModel(
                "1",
                "The Phantom Menace",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_1.jpg?alt=media&token=a3ad1c1c-6266-4e0c-971f-706a84c07f9f",
                1,
                1999,
                6.5
        ));
        films.add(new FilmModel(
                "2",
                "Attack of the Clones",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_2.jpg?alt=media&token=a72d2d5a-3f68-4657-953b-6513df32e4e6",
                2,
                2002,
                6.6
        ));
        films.add(new FilmModel(
                "3",
                "Revenge of the Sith",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_3.jpg?alt=media&token=1bc2631f-639a-4422-9af1-0611a6b2d11a",
                3,
                2005,
                7.6
        ));
        films.add(new FilmModel(
                "4",
                "A New Hope",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_4.jpg?alt=media&token=788be878-8055-4355-a848-be5ea2f4649a",
                4,
                1977,
                8.7
        ));
        films.add(new FilmModel(
                "5",
                "The Empire Strikes Back",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_5.jpg?alt=media&token=a4a596bb-64b7-4f08-987f-19ca59da3e88",
                5,
                1980,
                8.8
        ));
        films.add(new FilmModel(
                "6",
                "Return of the Jedi",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_6.jpg?alt=media&token=638bf39c-358c-4c77-870e-f655103612bc",
                6,
                1983,
                8.4

        ));
        films.add(new FilmModel(
                "7",
                "The Force Awakens",
                "https://firebasestorage.googleapis.com/v0/b/workshop-senec-my-first-app.appspot.com/o/episode_7.jpg?alt=media&token=f80349d0-9277-4790-bb32-ec4ee6806a97",
                7,
                2015,
                8.1
        ));
        return instance;
    }

    public List<FilmModel> getAllFilms() {
        return this.films;
    }

}