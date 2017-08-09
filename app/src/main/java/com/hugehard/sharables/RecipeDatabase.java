package com.hugehard.sharables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guidi on 8/8/2017.
 */

public class RecipeDatabase {
    private static ArrayList<Recipe> recipeList = new ArrayList<>();
    private static RecipeDatabase database;

    public RecipeDatabase(){

    }

    public static RecipeDatabase getInstance() {
        if (database == null){
            database = new RecipeDatabase();
        }
        return database;
    }

    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(ArrayList<Recipe> newList) {
        this.recipeList = newList;
    }

    public void addRecipe(Recipe recipe) {
        this.recipeList.add(0, recipe);
    }
}
