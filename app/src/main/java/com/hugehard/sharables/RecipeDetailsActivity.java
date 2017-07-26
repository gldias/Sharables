package com.hugehard.sharables;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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

        //Set preparation header text
        TextView preparationHeader = (TextView)findViewById(R.id.preparation_header);
        underlineText("How to prepare:", preparationHeader);
        //Set ingredient header text
        TextView ingredientHeader = (TextView)findViewById(R.id.ingredients_header);
        underlineText("What you will need:", ingredientHeader);
        //Set steps header text
        TextView stepsHeader = (TextView)findViewById(R.id.steps_header);
        underlineText("Steps", stepsHeader);

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

        TextView preparationView = (TextView)findViewById(R.id.preparation);
        preparationView.setText(preparation);

        ListView ingredientListView = (ListView)findViewById(R.id.ingredients_list);
        ArrayList<HashMap<String, String>> data = getIngredientsforListView(ingredients);
        final SimpleAdapter ingredientAdapter =
                new SimpleAdapter(this, data, android.R.layout.simple_list_item_2,
                        new String[] {"IngredientName", "IngredientQuantity"},
                        new int[] {android.R.id.text1, android.R.id.text2});
        ingredientListView.setAdapter(ingredientAdapter);
        ListViewHelper.getListViewSize(ingredientListView);

        ListView stepsListView = (ListView)findViewById(R.id.steps_list);
        ArrayAdapter<String> stepsAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, steps);
        stepsListView.setAdapter(stepsAdapter);
        ListViewHelper.getListViewSize(stepsListView);

    }

    public ArrayList<HashMap<String, String>> getIngredientsforListView(HashMap<String, String> ingredients){
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

        for (String item : ingredients.keySet()){
            HashMap<String, String> datum = new HashMap<>();
            datum.put("IngredientName", item);
            datum.put("IngredientQuantity", ingredients.get(item)); //TODO: change this to use sets
            data.add(datum);
        }

        return data;
    }

    public void underlineText(String text, TextView textView) {
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }
}
