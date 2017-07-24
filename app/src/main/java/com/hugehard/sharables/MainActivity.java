package com.hugehard.sharables;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.hugehard.sharables.MESSAGE";
    List<Recipe> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Test recipes
        String testTitle = "Bananas";
        String testAuthor = "Gui";
        int testTime = 20;

        HashMap<String, String> testIngredients = new HashMap<>();
        testIngredients.put("Bananas", "2 pieces");

        String testPreparation = "Buy some bananas";

        ArrayList<String> testSteps = new ArrayList<>();
        testSteps.add("Take some bananas");
        testSteps.add("Eat them!");

        Recipe testRecipe = new Recipe(testTitle, testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe);

        Recipe testRecipe2 = new Recipe("Apples", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe2);

        Recipe testRecipe3 = new Recipe("Oranges", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe3);

        Recipe testRecipe4 = new Recipe("PineapplesAndMorePineapples", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe4);

        Recipe testRecipe5 = new Recipe("Mangoes", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe5);

        Recipe testRecipe6 = new Recipe("Cherries", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe6);

        Recipe testRecipe7 = new Recipe("Clementines", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe7);

        Recipe testRecipe8 = new Recipe("Strawberries", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe8);

        Recipe testRecipe9 = new Recipe("Blueberries", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe9);
        //End test recipes

        ListView listView = (ListView)findViewById(R.id.list);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(this, R.layout.mylist, recipeList);
        listView.setAdapter(recipeListAdapter);

        //Click listener for list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, RecipeDetailsActivity.class);
                //Get the recipe at item position
                Recipe recipe = recipeList.get(position);

                //Get recipe data
                String title = recipe.getTitle();
                String author = recipe.getAuthor();
                int time = recipe.getCookTime();
                HashMap<String, String> ingredients = recipe.getIngredients();
                String preparation = recipe.getPreparation();
                ArrayList<String> steps = recipe.getSteps();

                //Send recipe data to RecipeDetails Activity
                intent.putExtra("title", title);
                intent.putExtra("author", author);
                intent.putExtra("time", time);
                intent.putExtra("ingredients", ingredients);
                intent.putExtra("preparation", preparation);
                intent.putExtra("steps", steps);

                //Start RecipeDetailsActivity
                startActivity(intent);
            }
        });

    }

}
