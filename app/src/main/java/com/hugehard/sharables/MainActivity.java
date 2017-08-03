package com.hugehard.sharables;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set up action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Test recipes
        String testTitle = "Bananas";
        String testAuthor = "Gui";
        int testTime = 20;

        HashMap<String, String> testIngredients = new HashMap<>();
        testIngredients.put("Bananas", "2 pieces");
        testIngredients.put("Your hands", "Both of them");

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

        Recipe testRecipe10 = new Recipe("Lemons", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe10);

        Recipe testRecipe11 = new Recipe("Limes", testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe11);
        //End test recipes

        listView = (ListView)findViewById(R.id.list);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(this, R.layout.mylist, recipeList);
        listView.setAdapter(recipeListAdapter);

        //Click listener for list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendRecipeClickDetails(recipeList, position);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();

            //Listen for queries and filter results
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    final List<Recipe> searchResults = new ArrayList<>();
                    for (Recipe recipe : recipeList) { //TODO: modify to use database
                        if (recipe.getTitle().toLowerCase().contains(query.toLowerCase())) {
                            searchResults.add(recipe); //I know this is inefficient
                        }
                    }
                    RecipeListAdapter searchAdapter = new RecipeListAdapter(MainActivity.this, R.layout.mylist, searchResults);
                    listView.setAdapter(searchAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            sendRecipeClickDetails(searchResults, position);
                        }
                    });

                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_recipe:
                Intent intent = new Intent(MainActivity.this, NewRecipeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void sendRecipeClickDetails(List<Recipe> recipeList, int position) {
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

}
