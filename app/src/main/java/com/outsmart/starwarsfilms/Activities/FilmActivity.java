package com.outsmart.starwarsfilms.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.outsmart.starwarsfilms.R;

public class FilmActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_card);

        TextView title = (TextView) findViewById(R.id.episode_title);
        ImageView image = (ImageView) findViewById(R.id.episode_image);

        title.setText("The Phantom Menace");
        image.setImageResource(R.drawable.episode_1);
    }

}
