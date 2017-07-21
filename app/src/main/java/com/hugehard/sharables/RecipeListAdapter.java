package com.hugehard.sharables;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guidi on 7/19/2017.
 */

public class RecipeListAdapter extends ArrayAdapter<Recipe> {
    //TODO: Change this to use the Recipe class

    private int layoutResource;

    public RecipeListAdapter(Context context, int layoutResource, List<Recipe> recipeList) {
        super(context, layoutResource, recipeList);
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        Recipe recipe = getItem(position);

        if (recipe != null) {
            ImageView recipeImage = (ImageView) view.findViewById(R.id.recipeImage);
            TextView recipeTitle = (TextView) view.findViewById(R.id.recipeTitle);
            TextView recipeAuthor = (TextView) view.findViewById(R.id.recipeAuthor);
            TextView recipeTime = (TextView) view.findViewById(R.id.recipeCookTime);

            if (recipeImage != null) {
                recipeImage.setImageResource(R.mipmap.ic_launcher); //TODO: fix to use Recipe's image
            }

            if (recipeTitle != null) {
                recipeTitle.setText(recipe.getTitle());
            }

            if (recipeAuthor != null) {
                recipeAuthor.setText(recipe.getAuthor());
            }

            if (recipeTime != null) {
                recipeTime.setText("Cook Time: " + recipe.getCookTimeAsString() + "min");
            }
        }

        return view;

    }
}
