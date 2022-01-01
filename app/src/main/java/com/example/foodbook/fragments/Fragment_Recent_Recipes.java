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
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Fragment_Recent_Recipes extends Fragment {
    private static final String RECIPE = "Recipe";
    private static final String TAG = "tag";
    private RecyclerView myRecipes_RECY_LAY;
    private List<Recipe> recipes = new ArrayList<>();
    private View view;
    private Recipe recipe;
    boolean isInWL = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_recipes , container,false);
        findViews(view);
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


    private void getRecipesFromMyWishListAndCheck(Recipe r){

    }

    private void addRecipesToListAndSetAdapter(Recipe r){
        recipes.add(r);
        Collections.sort(recipes, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o2.getRecipeTimeAndDate().compareTo(o1.getRecipeTimeAndDate());
            }
        });
        if(recipes.size() > 10) {
            List<Recipe> ten_recent_recipes = recipes.subList(0, 10);
            recipes = ten_recent_recipes;
        }
        Adapter_Recipes adapter_recipe = new Adapter_Recipes(getContext(), recipes);
        myRecipes_RECY_LAY.setLayoutManager(new LinearLayoutManager(view.getContext()));
        myRecipes_RECY_LAY.setAdapter(adapter_recipe);
        adapter_recipe.setClickListener(new Adapter_Recipes.MyItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                adapter_recipe.updateOneItem(position);
                Intent myIntent = new Intent(getActivity(), Activity_Specific_Recipe.class);
                myIntent.putExtra(RECIPE,recipes.get(position));
                myIntent.putExtra(TAG,"Fragment_Recent_Recipes");
                startActivity(myIntent);
                getActivity().finish();
            }

            @Override
            public void onAddToWishListClicked(View view, Recipe recipe, int position) {
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });
    }
}
