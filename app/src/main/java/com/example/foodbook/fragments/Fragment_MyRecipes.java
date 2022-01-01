package com.example.foodbook.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodbook.GlobalState;
import com.example.foodbook.activities.Activity_Specific_Recipe;
import com.example.foodbook.boundary.InstanceBoundary;
import com.example.foodbook.boundary.UserBoundary;
import com.example.foodbook.rest.RestClient;
import com.example.foodbook.rest.RestInterface;
import com.example.foodbook.utils.Adapter_Recipes;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_MyRecipes extends Fragment {
    private RecyclerView myRecipes_RECY_LAY;
    private List<Recipe> recipes = new ArrayList<>();
    private Adapter_Recipes adapter_recipe;
    private View view;
    private Recipe recipe;
    boolean isInWL = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_recipes , container,false);
        findViews(view);

        UserBoundary user = GlobalState.getLoggedUser().getLoggedUser();

        RestInterface restInterface = RestClient.createRetrofit().create(RestInterface.class);
        Call<InstanceBoundary[]> call = restInterface.getAllTypesLikeType(user.getUserId().getDomain(), user.getUserId().getEmail(), "RECIPE");
        call.enqueue(new Callback<InstanceBoundary[]>() {
            @Override
            public void onResponse(Call<InstanceBoundary[]> call, Response<InstanceBoundary[]> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext().getApplicationContext(), "Something wrong, Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                recipes = new ArrayList<>();
                for (InstanceBoundary instanceBoundary : response.body()) {
                    if (!instanceBoundary.getCreatedBy().getUserId().equals(user.getUserId())) {
                        continue;
                    }

                    Recipe recipe = new Recipe();
                    recipe.setCategory(Recipe.RecipeCategory.valueOf(instanceBoundary.getInstanceAttributes().get("category").toString()));
                    recipe.setRecipeName(instanceBoundary.getName());
                    recipe.setRecipeIngredients(instanceBoundary.getInstanceAttributes().get("ingredients").toString());
                    recipe.setRecipeDirections(instanceBoundary.getInstanceAttributes().get("directions").toString());
                    recipe.setPreparationTime(instanceBoundary.getInstanceAttributes().get("preptime").toString());

                    recipes.add(recipe);
                }

                adapter_recipe = new Adapter_Recipes(getContext(), recipes);
                myRecipes_RECY_LAY.setLayoutManager(new LinearLayoutManager(view.getContext()));
                myRecipes_RECY_LAY.setAdapter(adapter_recipe);
                adapter_recipe.setClickListener(new Adapter_Recipes.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        adapter_recipe.updateOneItem(position);
                        Intent myIntent = new Intent(getActivity(), Activity_Specific_Recipe.class);
                        myIntent.putExtra("Recipe",recipes.get(position));
                        myIntent.putExtra("tag","Fragment_MyRecipes");
                        startActivity(myIntent);
                        getActivity().finish();
                    }
                    @Override
                    public void onAddToWishListClicked(View view, Recipe recipe, int position) {
                    }
                });
            }

            @Override
            public void onFailure(Call<InstanceBoundary[]> call, Throwable t) {
                Toast.makeText(view.getContext().getApplicationContext(), "Something wrong", Toast.LENGTH_LONG).show();
            }
        });

        initViews();
        return view;
    }


    private void findViews(View view) {
        myRecipes_RECY_LAY = view.findViewById(R.id.myRecipes_RECY_LAY);
    }

    private void initViews() {
        getRecipesFromDB();


    }
    private void  getRecipesFromDB() {

    }


    private void getRecipesFromMyWishList(Recipe r){

    }
}
