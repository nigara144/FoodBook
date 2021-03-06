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
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodbook.utils.AppManager;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;


public class Activity_Edit_Recipe extends AppCompatActivity {
    private static final String CATEGORY = "category";
    private static final String RECIPE = "Recipe";
    private static final String TAG = "tag";
    private static final String ISINWL = "isInWL";
    private static final int REQUEST_CODE = 1;
    //Utils
    private AppManager appManager;
    private MimeTypeMap mime;
    private Intent myIntent;
    private ContentResolver cR;
    //Views
    private ImageButton back_button;
    private Button done_With_Edit_Recipe_BTN;
    private TextView recipe_title_LBL;
    private EditText recipe_ingredients_LBL;
    private EditText recipe_directions_LBL;
    private EditText recipe_prep_time;
    private Spinner recipe_category;
    private ImageView recipe_scpecific_Edit_IMG;
    private Recipe.RecipeCategory recipeCategory;
    //Vars
    private boolean isRecipeInwl;
    private String recipeName;
    private String recipeIng;
    private String recipeDir;
    private String recipePreTime;
    private String uri_string;
    private String fragment_tag;
    private String category;
    private Uri imageUri;
    private Uri downloadUri;
    private Recipe recipe = new Recipe();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.specific_recipe_edit_layout);
        super.onCreate(savedInstanceState);
        appManager = new AppManager(this);
        appManager.findViewsMyRecipes(this);
            cR = getContentResolver();
        mime = MimeTypeMap.getSingleton();
        findViews();
        initViews();
    }

    private void findViews() {
        back_button = findViewById(R.id.back_button);
        done_With_Edit_Recipe_BTN = findViewById(R.id.done_With_Edit_Recipe_BTN);
        recipe_ingredients_LBL = findViewById(R.id.recipe_ingredients_LBL);
        recipe_directions_LBL = findViewById(R.id.recipe_directions_LBL);
        recipe_prep_time = findViewById(R.id.recipe_prep_time);
        recipe_category = findViewById(R.id.recipe_category);
        recipe_scpecific_Edit_IMG = findViewById(R.id.recipe_scpecific_Edit_IMG);
        recipe_title_LBL =findViewById(R.id.recipe_title_LBL);
    }

    private void initViews() {
        fragment_tag = getIntent().getStringExtra(TAG);
        isRecipeInwl = getIntent().getBooleanExtra(ISINWL,false);
        recipe = (Recipe) getIntent().getSerializableExtra(RECIPE);
        category = getIntent().getStringExtra(CATEGORY);
        set_all_recipe_info(recipe);
        back_button.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(Activity_Edit_Recipe.this, Activity_Specific_Recipe.class);
                myIntent.putExtra(RECIPE,recipe);
                myIntent.putExtra(TAG,fragment_tag);
                myIntent.putExtra(CATEGORY,category);
                startActivity(myIntent);
                finish();
            }
        });
        done_With_Edit_Recipe_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        recipe_scpecific_Edit_IMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
    }

    public void set_all_recipe_info(Recipe recipe){
        recipe_title_LBL.setText(recipe.getRecipeName());
        recipe_ingredients_LBL.setText(recipe.getRecipeIngredients());
        recipe_directions_LBL.setText(recipe.getRecipeDirections());
        recipe_prep_time.setText(recipe.getPreparationTime());
        Glide.with(this).load(recipe.getRecipeImage()).apply(RequestOptions.centerInsideTransform()).into(recipe_scpecific_Edit_IMG);
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
                            Glide.with(this).load(imageUri).apply(RequestOptions.centerCropTransform()).into(recipe_scpecific_Edit_IMG);
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


    private void getAllRecipeInfo(){
        String category = "";
        recipeName = recipe.getRecipeName();
        recipeIng = recipe_ingredients_LBL.getText().toString();
        recipeDir = recipe_directions_LBL.getText().toString();
        recipePreTime = recipe_prep_time.getText().toString();
        if(!recipe_category.getSelectedItem().toString().equals("Category")) {
           category = recipe_category.getSelectedItem().toString();
           recipeCategory = Recipe.RecipeCategory.valueOf(category);
        }else{
            recipeCategory = recipe.getCategory();
        }
        imageUri = downloadUri;
        if(imageUri != null){
            uri_string = imageUri.toString();
        }else {
            uri_string = recipe.getRecipeImage();
        }
        recipe = new Recipe(recipeName, recipeIng, recipeDir, recipePreTime, recipeCategory,
                uri_string ,isRecipeInwl, recipe.getRecipeTimeAndDate(), recipe.getUserUid(),
                recipe.getRatingAvg(), recipe.getRating(), recipe.getCountRate(),
                recipe.getDiffLevel());
    }



}

