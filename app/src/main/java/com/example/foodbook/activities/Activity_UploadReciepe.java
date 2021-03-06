package com.example.foodbook.activities;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbook.GlobalState;
import com.example.foodbook.boundary.InstanceBoundary;
import com.example.foodbook.boundary.UserBoundary;
import com.example.foodbook.boundaryhelpers.CreatedBy;
import com.example.foodbook.boundaryhelpers.InstanceId;
import com.example.foodbook.boundaryhelpers.Location;
import com.example.foodbook.model.MainData;
import com.example.foodbook.rest.RestClient;
import com.example.foodbook.rest.RestInterface;
import com.example.foodbook.utils.AppManager;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
import com.example.foodbook.objects.User;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import com.google.firebase.firestore.QuerySnapshot;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;



public class Activity_UploadReciepe extends AppCompatActivity implements View.OnClickListener {
    private static final String F_WHICH_ACTIVITY = "F_WHICH_ACTIVITY";
    private static final int REQUEST_CODE = 1;
    private AppManager appManager;
    private String recipeName;
    private Map<String, Object> userRecipes;
    private ArrayList<Recipe> recipes;
    private Recipe recipe;
    private User user;
    private Uri imageUri;
    private Uri downloadUri;
    private String which_Activity;
    //views
    private Button doneUpload_BTN;
    private ImageButton backto_myFeed_BTN;
    private ImageView recipe_upload_IMG;
    private EditText recipe_Name_LBL;
    private Spinner recipe_category_LBL;
    private EditText recipe_ingredients_UPLD_LBL;
    private EditText recipe_directions_UPLD_LBL;
    private EditText preparation_Time_LBL;
    private ProgressBar progress_bar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_reciepe_screen);
        appManager = new AppManager(this);
        appManager.findViewsUploadReciepe(this);
        user = new User();
        recipes = new ArrayList<>();
        userRecipes = new HashMap<>();
        findViews();
        initViews();
    }

    private void findViews() {
        doneUpload_BTN = appManager.getDoneUpload_BTN();
        backto_myFeed_BTN = appManager.getBackto_myFeed_BTN();
        recipe_upload_IMG = appManager.getRecipe_upload_IMG();
        recipe_Name_LBL = appManager.getRecipe_Name_LBL();
        recipe_category_LBL = appManager.getRecipe_category_LBL();
        recipe_ingredients_UPLD_LBL = appManager.getRecipe_ingredients_UPLD_LBL();
        recipe_directions_UPLD_LBL = appManager.getRecipe_directions_UPLD_LBL();
        preparation_Time_LBL = appManager.getPreparation_Time_LBL();
        progress_bar = findViewById(R.id.progress_bar);
    }

    private void initViews() {
        recipe_upload_IMG.setOnClickListener(this);
        doneUpload_BTN.setOnClickListener(this);
        backto_myFeed_BTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.recipe_upload_IMG:
                chooseImage();
                break;
            case R.id.doneUpload_BTN:
                progress_bar.setVisibility(View.VISIBLE);

                UserBoundary mainData = GlobalState.getLoggedUser().getLoggedUser();

                HashMap<String, Object> attributes = new HashMap<>();
                attributes.put("category", recipe_category_LBL.getSelectedItem().toString());
                attributes.put("ingredients", recipe_ingredients_UPLD_LBL.getText().toString());
                attributes.put("directions", recipe_directions_UPLD_LBL.getText().toString());
                attributes.put("preptime", preparation_Time_LBL.getText().toString());

                InstanceBoundary instanceBoundary = new InstanceBoundary(
                        new InstanceId(),
                        "RECIPE",
                        recipe_Name_LBL.getText().toString(),
                        true,
                        null,
                        new CreatedBy(),
                        new Location(),
                        attributes
                );

                RestInterface restInterface = RestClient.createRetrofit().create(RestInterface.class);
                Call<InstanceBoundary> call = restInterface.createNewInstance(
                        "2022A.Roei.Berko", mainData.getUserId().getEmail(), instanceBoundary
                );
                call.enqueue(new Callback<InstanceBoundary>() {
                    @Override
                    public void onResponse(Call<InstanceBoundary> call, Response<InstanceBoundary> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Something wrong, Code: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        Intent myIntent = new Intent(Activity_UploadReciepe.this, Activity_MyFeed.class);
                        startActivity(myIntent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<InstanceBoundary> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Something wrong check it", Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.backto_myFeed_BTN:
                Intent myIntent = new Intent(Activity_UploadReciepe.this, Activity_MyFeed.class);
                startActivity(myIntent);
                finish();
                break;
        }
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);

}

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case REQUEST_CODE:
                    if (resultCode == Activity.RESULT_OK) {
                        imageUri = data.getData();
                        if(imageUri!= null){
                            Glide.with(this).load(imageUri).apply(RequestOptions.centerCropTransform()).into(recipe_upload_IMG);
                        }
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.d("failed", "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("Exception", "Exception in onActivityResult : " + e.getMessage());
        }
    }




    private void addSpecificRecipe(){
        recipeName = recipe_Name_LBL.getText().toString();
        String recipeIng = recipe_ingredients_UPLD_LBL.getText().toString();
        String recipeDir = recipe_directions_UPLD_LBL.getText().toString();
        String recipePreTime = preparation_Time_LBL.getText().toString();
        String category = recipe_category_LBL.getSelectedItem().toString();
        if(category.equals("Select Category")){
            Toast.makeText(Activity_UploadReciepe.this,"Please Select an category!",
                    Toast.LENGTH_LONG).show();
        }
        Recipe.RecipeCategory recipeCategory = Recipe.RecipeCategory.valueOf(category);
        imageUri = downloadUri;
        String uri_string = imageUri.toString();
        recipes.add(recipe);
        user.addRecipe(recipes);
    }



}
