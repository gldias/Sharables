package com.hugehard.sharables;

/**
 * Created by guidi on 7/19/2017.
 */

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Recipe {
    //TODO: Fix the way you store images
    //TODO: change ingredients to be a set

    //Date is assigned at object creation (when recipe is uploaded)
    private Date dateCreated = new Date();
    private String title;
    private String author;
    private int cookTime; //The cook time is represented in minutes
    private Image recipeImg;
    private HashMap<String, String> ingredients; //Key: ingredient; Value: quantity
    private String preparation;
    private ArrayList<String> steps;

    public Recipe(String title, String author, int cookTime, HashMap<String, String> ingredients,
                  String preparation, ArrayList<String> steps){
        this.title = title;
        this.author = author;
        this.cookTime = cookTime;
        //this.recipeImg = recipeImg;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.steps = steps;
    }

    /*
        Getters and setters
     */

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getCookTime() {
        return cookTime;
    }

    public String getCookTimeAsString(){
        return Integer.toString(this.cookTime);
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public Image getRecipeImg() {
        return recipeImg;
    }

    public void setRecipeImg(Image recipeImg) {
        this.recipeImg = recipeImg;
    }

    public HashMap<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /*
        End getters and setters
     */

    /**
     * toString method for each recipe
     * @return the recipe's title
     */
    @Override
    public String toString(){
        return this.title;
    }
}
