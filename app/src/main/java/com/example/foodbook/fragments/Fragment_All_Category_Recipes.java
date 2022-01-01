package com.example.foodbook.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodbook.utils.Adapter_Recipes;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
import com.example.foodbook.activities.Activity_Specific_Recipe;
import java.util.ArrayList;
import java.util.List;


public class Fragment_All_Category_Recipes extends Fragment {
    private static final String CATEGORY = "category";
    private static final String RECIPE = "Recipe";
    private static final String TAG = "tag";
    private RecyclerView categories_LST_names;
    private List<Recipe> all_category_recipes = new ArrayList<>();
    private boolean isInWL;
    private View view;
    private Recipe recipe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories_list , container,false);
        findViews(view);
        return view;
    }



    private void findViews(View view) {
        categories_LST_names = view.findViewById(R.id.categories_LST_names);
    }



    private void addRecipesToListAndSetAdapter(Recipe r, String categoryName){
        all_category_recipes.add(r);
        Adapter_Recipes adapter_recipe = new Adapter_Recipes(getContext(), all_category_recipes);
        categories_LST_names.setLayoutManager(new LinearLayoutManager(view.getContext()));
        categories_LST_names.setAdapter(adapter_recipe);
        adapter_recipe.setClickListener(new Adapter_Recipes.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                adapter_recipe.updateOneItem(position);
                showSpecificRecipe(all_category_recipes.get(position) ,categoryName);
            }
            @Override
            public void onAddToWishListClicked(View view, Recipe recipe, int position) {
                isInWL = true;
            }
        });
    }

    private void showSpecificRecipe(Recipe recipe , String categoryName) {
        Intent myIntent = new Intent(getActivity(), Activity_Specific_Recipe.class);
        myIntent.putExtra(RECIPE,recipe);
        myIntent.putExtra(TAG,"Fragment_All_Category_Recipes");
        myIntent.putExtra(CATEGORY , categoryName);
        startActivity(myIntent);
        getActivity().finish();
    }


}


