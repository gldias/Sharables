package com.hugehard.sharables;

/**
 * Created by guidi on 7/19/2017.
 */

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Recipe implements Parcelable{
    //TODO: Fix the way you store images
    //TODO: change ingredients to be a set

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

    private Recipe(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.cookTime = in.readInt();
        //this.recipeImg = recipeImg;
        this.ingredients = in.readHashMap(String.class.getClassLoader());
        this.preparation = in.readString();
        this.steps = in.readArrayList(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.title);
        out.writeString(this.author);
        out.writeInt(this.cookTime);
        out.writeMap(this.ingredients);
        out.writeString(this.preparation);
        out.writeList(this.steps);
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
