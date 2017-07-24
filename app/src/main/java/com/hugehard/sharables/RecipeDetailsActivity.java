package com.hugehard.sharables;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Get toolbar layout so that we can change the title later
        CollapsingToolbarLayout toolbarLayout =
                (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get data from recipe click
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        int cookTime = intent.getIntExtra("time", 0); //default value for cookTime is 0
        HashMap<String, String> ingredients =
                (HashMap<String, String>) intent.getSerializableExtra("ingredients");
        String preparation = intent.getStringExtra("preparation");
        ArrayList<String> steps = intent.getStringArrayListExtra("steps");

        //Change toolbar title to recipe name
        toolbarLayout.setTitle(title);

        //Put data in the views
        ImageView imageView = (ImageView)findViewById(R.id.recipeDetailsImage);
        imageView.setImageResource(R.mipmap.ic_launcher);

        TextView recipeTitleView = (TextView)findViewById(R.id.recipeDetailsTitle);
        recipeTitleView.setText(title);

        TextView recipeAuthorView = (TextView)findViewById(R.id.recipeDetailsAuthor);
        recipeAuthorView.setText("By: " + author);

        TextView recipeTimeView = (TextView)findViewById(R.id.recipeDetailsCookTime);
        recipeTimeView.setText("Cook Time: " + Integer.toString(cookTime) + "min");
    }
}
