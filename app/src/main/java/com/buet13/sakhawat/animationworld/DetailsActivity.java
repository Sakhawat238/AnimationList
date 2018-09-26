package com.buet13.sakhawat.animationworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {
    private TextView fullTitle,details,year2,imdb_id,imdb_rat,lan,run;
    private ImageView imV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fullTitle = findViewById(R.id.full_title);
        details = findViewById(R.id.details);
        year2 = findViewById(R.id.year2);
        imdb_id = findViewById(R.id.imdb_id);
        imdb_rat = findViewById(R.id.imdb_rat);
        lan = findViewById(R.id.language);
        imV = findViewById(R.id.thumbnail);

        Intent i = getIntent();
        String t = i.getStringExtra("t");
        String ft = i.getStringExtra("ft");
        String dt = i.getStringExtra("dt");
        String y = i.getStringExtra("y");
        String l = i.getStringExtra("l");
        String id = i.getStringExtra("id");
        String ir = i.getStringExtra("ir");
        String url = i.getStringExtra("im");

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(t);

        fullTitle.setText(ft);
        details.setText(dt);
        year2.setText("Year: "+y);
        imdb_id.setText("IMDB Id: "+id);
        imdb_rat.setText("IMDB Rating: "+ir);
        lan.setText("Language: "+l);

        Glide.with(this).load(url).into(imV);
        //Picasso.with(context).load(ImageURL).resize(width,height).into(imageView);

    }
}
