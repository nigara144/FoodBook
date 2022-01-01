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
import com.example.foodbook.utils.Adapter_MyWishList;
import com.example.foodbook.utils.Adapter_WishList;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
import com.example.foodbook.activities.Activity_MyFeed;
import com.example.foodbook.activities.Activity_MyWishList;
import com.example.foodbook.activities.Activity_Specific_Recipe;
//import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.List;


public class Fragment_wishList extends Fragment {
    private static final String RECIPE = "Recipe";
    private static final String TAG = "tag";
    private RecyclerView wishList_RECY_LAY;
    private RecyclerView myRecipes_RECY_LAY;
    private Recipe recipe = new Recipe();
    private List<Recipe> recipes_WishList ;
    private View view;
    private String which_Activity="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getActivity() instanceof Activity_MyFeed){
            view = inflater.inflate(R.layout.fragment_wish_list , container,false);
            which_Activity = "Activity_MyFeed";
        }else if(getActivity() instanceof Activity_MyWishList){
            view = inflater.inflate(R.layout.fragment_my_recipes , container,false);
            which_Activity = "Activity_MyWishList";
        }
        recipes_WishList = new ArrayList<>();
        findViews(view);
        initViews();
        return view;
    }

    private void findViews(View view) {
        wishList_RECY_LAY = view.findViewById(R.id.wishList_RECY_LAY);
        myRecipes_RECY_LAY = view.findViewById(R.id.myRecipes_RECY_LAY);
    }

    private void initViews() {
        getAllWishListRecipesFromDB();
    }


    private void getAllWishListRecipesFromDB(){

    }

    private void setAdapterWishList(RecyclerView rv){
        Adapter_WishList adapter_recipe = new Adapter_WishList(getContext(), recipes_WishList);
        rv.setAdapter(adapter_recipe);
        adapter_recipe.setClickListener(new Adapter_WishList.MyItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Intent myIntent = new Intent(getActivity(), Activity_Specific_Recipe.class);
                myIntent.putExtra(RECIPE,recipes_WishList.get(position));
                myIntent.putExtra(TAG,"Fragment_wishList");
                startActivity(myIntent);
                getActivity().finish();
            }

            @Override
            public void onWishListClicked(View view, Recipe recipe) {
                recipe.setInWishList(false);
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });
    }

    private void setAdapterMyRecipesForWL(RecyclerView rv){
        Adapter_MyWishList adapter_mWL = new Adapter_MyWishList(getContext(),recipes_WishList);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rv.setAdapter(adapter_mWL);
        adapter_mWL.setClickListener(new Adapter_MyWishList.MyItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Intent myIntent = new Intent(getActivity(), Activity_Specific_Recipe.class);
                myIntent.putExtra(RECIPE,recipes_WishList.get(position));
                myIntent.putExtra(TAG,"Fragment_myWL");
                startActivity(myIntent);
                getActivity().finish();
            }
            @Override
            public void onWishListClicked(View view, Recipe recipe) {
                recipe.setInWishList(false);
                getActivity().finish();
                startActivity(getActivity().getIntent());

            }
        });
    }
}

