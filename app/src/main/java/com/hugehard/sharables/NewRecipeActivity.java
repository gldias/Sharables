package com.hugehard.sharables;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewRecipeActivity extends AppCompatActivity {

    private LinearLayout ingredientsView;
    private Button addNewIngredientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Get toolbar layout so that we can change the title
        CollapsingToolbarLayout toolbarLayout =
                (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Add New Recipe");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ingredientsView = (LinearLayout)findViewById(R.id.recipe_ingredients_wrapper);
        addNewIngredientButton = (Button) findViewById(R.id.add_new_ingredient_button);
        addNewIngredientButton.setOnClickListener(onClick());
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIngredientInputLine();
            }
        };
    }

    private void addIngredientInputLine() {
        LinearLayout ingredientInput = (LinearLayout)findViewById(R.id.recipe_ingredients_input);

        LinearLayout newLine = new LinearLayout(this);
        EditText ingredientName = new EditText(this);
        EditText ingredientQuantity = new EditText(this);

        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams ingName = new LinearLayout.LayoutParams(192, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams ingQuant = new LinearLayout.LayoutParams(148, ViewGroup.LayoutParams.WRAP_CONTENT);

        newLine.setLayoutParams(linearLayout);
        newLine.setOrientation(LinearLayout.HORIZONTAL);

        ingredientName.setLayoutParams(ingName);
        ingredientName.setHint("Ingredient Name");
        newLine.addView(ingredientName);

        ingredientQuantity.setLayoutParams(ingQuant);
        ingredientQuantity.setHint("Quantity");
        newLine.addView(ingredientQuantity);

        ingredientInput.addView(newLine);
    }
}
