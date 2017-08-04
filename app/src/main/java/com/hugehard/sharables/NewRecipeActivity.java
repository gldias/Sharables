package com.hugehard.sharables;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewRecipeActivity extends AppCompatActivity {

    private LinearLayout ingredientsView;
    private LinearLayout stepsView;
    private Button addNewIngredientButton;
    private Button addNewStepButton;

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

        //Get ingredients linear layout so that we can dynamically add more input fields
        ingredientsView = (LinearLayout)findViewById(R.id.recipe_ingredients_wrapper);

        //Get steps linear layout so that we can dynamically add more input fields
        stepsView = (LinearLayout)findViewById(R.id.recipe_steps_input);

        //Get new ingredient button and set click listener
        addNewIngredientButton = (Button) findViewById(R.id.add_new_ingredient_button);
        addNewIngredientButton.setOnClickListener(onClickIngredient());

        //Get new step button and set click listener
        addNewStepButton = (Button) findViewById(R.id.add_new_step_button);
        addNewStepButton.setOnClickListener(onClickStep());
    }

    private View.OnClickListener onClickIngredient() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIngredientInputLine();
            }
        };
    }

    private View.OnClickListener onClickStep() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStepsInputLine();
            }
        };
    }

    private void addIngredientInputLine() {
        LinearLayout newLine = new LinearLayout(this);
        EditText ingredientName = new EditText(this);
        EditText ingredientQuantity = new EditText(this);

        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setMargins(convertDPtoPixel(16, this), 0, 0, 0);
        LinearLayout.LayoutParams ingName = new LinearLayout.LayoutParams(convertDPtoPixel(192, this), ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams ingQuant = new LinearLayout.LayoutParams(convertDPtoPixel(148, this), ViewGroup.LayoutParams.WRAP_CONTENT);

        newLine.setLayoutParams(linearLayout);
        newLine.setOrientation(LinearLayout.HORIZONTAL);

        ingredientName.setLayoutParams(ingName);
        ingredientName.setHint("Ingredient Name");
        ingredientName.setInputType(InputType.TYPE_CLASS_TEXT);
        newLine.addView(ingredientName);

        ingredientQuantity.setLayoutParams(ingQuant);
        ingredientQuantity.setHint("Quantity");
        ingredientQuantity.setInputType(InputType.TYPE_CLASS_TEXT);
        newLine.addView(ingredientQuantity);

        ingredientsView.addView(newLine);
    }

    private void addStepsInputLine() {
        EditText newStep = new EditText(this);

        LinearLayout.LayoutParams step = new LinearLayout.LayoutParams(convertDPtoPixel(345, this), ViewGroup.LayoutParams.WRAP_CONTENT);

        newStep.setLayoutParams(step);
        newStep.setHint("Step");
        newStep.setInputType(InputType.TYPE_CLASS_TEXT);

        stepsView.addView(newStep);
    }

    private static int convertDPtoPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        int pixelValue = (int)px;
        return pixelValue;
    }
}
