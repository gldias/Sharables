package com.hugehard.sharables;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Recipe> recipeList = new ArrayList<>();

        String testTitle = "Bananas";
        String testAuthor = "Gui";
        int testTime = 20;

        Map<String, String> testIngredients = new HashMap<>();
        testIngredients.put("Bananas", "2 pieces");

        String testPreparation = "Buy some bananas";

        LinkedList<String> testSteps = new LinkedList<>();
        testSteps.add("Take some bananas");
        testSteps.add("Eat them!");

        Recipe testRecipe = new Recipe(testTitle, testAuthor, testTime, testIngredients, testPreparation, testSteps);
        recipeList.add(testRecipe);

        ListView listView = (ListView)findViewById(R.id.list);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(this, R.layout.mylist, recipeList);
        listView.setAdapter(recipeListAdapter);

    }
}
