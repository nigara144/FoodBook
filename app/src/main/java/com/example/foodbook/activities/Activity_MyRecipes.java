package com.example.foodbook.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbook.GlobalState;
import com.example.foodbook.boundary.InstanceBoundary;
import com.example.foodbook.boundary.NewUserBoundary;
import com.example.foodbook.boundary.UserBoundary;
import com.example.foodbook.rest.RestClient;
import com.example.foodbook.rest.RestInterface;
import com.example.foodbook.utils.AppManager;
import com.example.foodbook.fragments.Fragment_MyRecipes;
import com.example.foodbook.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Activity_MyRecipes extends AppCompatActivity  {
    private static final String F_WHICH_ACTIVITY = "F_WHICH_ACTIVITY";
    private static final String ACTIVITY_MYRECIPES = "Activity_MyRecipes";
    private ImageButton backto_myFeed_BTN;
    private Button upload_recipe_BTN_myRcipes;
    private Fragment_MyRecipes fragment_myRecipes;
    private AppManager appManager;
    private Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.my_recieps_screen);
        super.onCreate(savedInstanceState);
        appManager = new AppManager(this);
        appManager.findViewsMyRecipes(this);
        fragment_myRecipes = new Fragment_MyRecipes();
        findViews();
        initViews();
        getSupportFragmentManager().beginTransaction().add(R.id.myRecipes_LAY_list, fragment_myRecipes).commit();
    }

    private void findViews() {
        backto_myFeed_BTN = appManager.getBackto_myFeed_BTN();
        upload_recipe_BTN_myRcipes = appManager.getUpload_recipe_BTN_myRcipes();

    }

    private void initViews() {
        backto_myFeed_BTN.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_MyRecipes.this, Activity_MyFeed.class);
                startActivity(myIntent);
                finish();
            }
        });
        upload_recipe_BTN_myRcipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(Activity_MyRecipes.this, Activity_UploadReciepe.class);
                myIntent.putExtra(F_WHICH_ACTIVITY, ACTIVITY_MYRECIPES);
                startActivity(myIntent);
                finish();
            }
        });
    }
}
