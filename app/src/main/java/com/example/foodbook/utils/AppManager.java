package com.example.foodbook.utils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodbook.R;

public class AppManager {
    //Login Screen
    EditText login_email_LBL;
    EditText login_password_LBL;
    Button login_BTN;
    Button google_BTN_signup;
    Button signup_manualy_BTN;

    //SignUp Screen
    EditText signUp_uName_LBL;
    EditText signUp_email_LBL;
    EditText signUp_password_LBL;
    EditText verify_password_LBL;
    ImageButton back_button;
    Button signup_BTN;

    //myFeed screen
    Button upload_recipe_BTN;
    ImageButton logout_button;
    ImageView user_img_IMG;


    //UploadReciepe Screen
    ImageButton backto_myFeed_BTN;
    Button doneUpload_BTN;
    ImageView recipe_upload_IMG;
    EditText recipe_Name_LBL;
    Spinner recipe_category_LBL;
    EditText recipe_ingredients_UPLD_LBL;
    EditText recipe_directions_UPLD_LBL;
    EditText preparation_Time_LBL;

    //Fragment_Recipe
    TextView recipe_title_LBL;
    TextView recipe_ingredients_LBL;
    TextView recipe_directions_LBL;
    TextView recipe_prep_time;
    TextView recipe_category;
    ImageView recipe_scpecific_IMG;
    Button done_With_Recipe_BTN;

    //Adapter_Recipe
    ImageView recipe_img_IMG;
    TextView name_RECIPE_LBL;
    TextView category_RECIPE_LBL;
    TextView prep_TIME_LBL;
    TextView description__RECIPE_LBL;


    //MyRecipes Screen
    Button upload_recipe_BTN_myRcipes;
    RecyclerView myRecipes_RECY_LAY;

    public AppManager(AppCompatActivity activity){
    }

    public AppManager() {
    }


    public void findViewsLogin(AppCompatActivity activity) {
        login_email_LBL = activity.findViewById(R.id.login_email_LBL);
        login_password_LBL = activity.findViewById(R.id.login_password_LBL);
        login_BTN = activity.findViewById(R.id.login_BTN);
        signup_manualy_BTN =activity.findViewById(R.id.signup_manualy_BTN);

    }

    public void findViewsSignUp(AppCompatActivity activity) {
        signUp_uName_LBL = activity.findViewById(R.id.signUp_uName_LBL);
        signUp_email_LBL = activity.findViewById(R.id.signUp_email_LBL);
        signUp_password_LBL = activity.findViewById(R.id.signUp_password_LBL);
        verify_password_LBL = activity.findViewById(R.id.verify_password_LBL);
        signup_BTN = activity.findViewById(R.id.signup_BTN);
        back_button = activity.findViewById(R.id.back_button);
    }

    public void findViewsMyFeed(AppCompatActivity activity){
        upload_recipe_BTN = activity.findViewById(R.id.upload_recipe_BTN);
        logout_button = activity.findViewById(R.id.logout_button);
        user_img_IMG = activity.findViewById(R.id.user_img_IMG);
    }

    public void findViewsUploadReciepe(AppCompatActivity activity){
        backto_myFeed_BTN = activity.findViewById(R.id.backto_myFeed_BTN);
        doneUpload_BTN = activity.findViewById(R.id.doneUpload_BTN);
        recipe_upload_IMG = activity.findViewById(R.id.recipe_upload_IMG);
        recipe_Name_LBL = activity.findViewById(R.id.recipe_Name_LBL);
        recipe_category_LBL = activity.findViewById(R.id.recipe_category_LBL);
        recipe_ingredients_UPLD_LBL = activity.findViewById(R.id.recipe_ingredients_UPLD_LBL);
        recipe_directions_UPLD_LBL = activity.findViewById(R.id.recipe_directions_UPLD_LBL);
        preparation_Time_LBL = activity.findViewById(R.id.preparation_Time_LBL);
    }

    public void findViewsMyRecipes(AppCompatActivity activity){
        backto_myFeed_BTN = activity.findViewById(R.id.backto_myFeed_BTN);
        upload_recipe_BTN_myRcipes = activity.findViewById(R.id.upload_recipe_BTN_myRcipes);

    }
    public void findViewsCategoriesScreen(AppCompatActivity activity){
        backto_myFeed_BTN = activity.findViewById(R.id.backto_myFeed_BTN);

    }
    public void findViewsAdpterRecipe(View itemView){
        recipe_img_IMG = itemView.findViewById(R.id.recipe_img_IMG);
        name_RECIPE_LBL = itemView.findViewById(R.id.name_RECIPE_LBL);
        category_RECIPE_LBL = itemView.findViewById(R.id.category_RECIPE_LBL);
        prep_TIME_LBL = itemView.findViewById(R.id.prep_TIME_LBL);
        description__RECIPE_LBL = itemView.findViewById(R.id.description__RECIPE_LBL);
    }
    public void findViewsFragmentRecipe(View itemView){
        recipe_title_LBL = itemView.findViewById(R.id.recipe_title_LBL);
        recipe_ingredients_LBL = itemView.findViewById(R.id.recipe_ingredients_LBL);
        recipe_directions_LBL = itemView.findViewById(R.id.recipe_directions_LBL);
        recipe_prep_time = itemView.findViewById(R.id.recipe_prep_time);
        recipe_category = itemView.findViewById(R.id.recipe_category);
        recipe_scpecific_IMG = itemView.findViewById(R.id.recipe_scpecific_IMG);
        done_With_Recipe_BTN = itemView.findViewById(R.id.done_With_Recipe_BTN);

    }
    public EditText getLogin_email_LBL() {
        return login_email_LBL;
    }

    public EditText getLogin_password_LBL() {
        return login_password_LBL;
    }

    public Button getLogin_BTN() {
        return login_BTN;
    }

    public Button getGoogle_BTN_signup() {
        return google_BTN_signup;
    }

    public Button getSignup_manualy_BTN() {
        return signup_manualy_BTN;
    }

    public EditText getSignUp_uName_LBL() {
        return signUp_uName_LBL;
    }

    public EditText getSignUp_email_LBL() {
        return signUp_email_LBL;
    }

    public EditText getSignUp_password_LBL() {
        return signUp_password_LBL;
    }

    public EditText getVerify_password_LBL() {
        return verify_password_LBL;
    }

    public Button getSignup_BTN() {
        return signup_BTN;
    }

    public Button getUpload_recipe_BTN() {
        return upload_recipe_BTN;
    }

    public ImageButton getBackto_myFeed_BTN() {
        return backto_myFeed_BTN;
    }

    public Button getDoneUpload_BTN() {
        return doneUpload_BTN;
    }

    public ImageButton getLogout_button() {
        return logout_button;
    }

    public ImageButton getBack_button() {
        return back_button;
    }

    public ImageView getRecipe_upload_IMG() {
        return recipe_upload_IMG;
    }

    public EditText getRecipe_Name_LBL() {
        return recipe_Name_LBL;
    }

    public Spinner getRecipe_category_LBL() {
        return recipe_category_LBL;
    }

    public EditText getRecipe_ingredients_UPLD_LBL() {
        return recipe_ingredients_UPLD_LBL;
    }

    public EditText getRecipe_directions_UPLD_LBL() {
        return recipe_directions_UPLD_LBL;
    }

    public EditText getPreparation_Time_LBL() {
        return preparation_Time_LBL;
    }

    public ImageView getUser_img_IMG() {
        return user_img_IMG;
    }

    public Button getUpload_recipe_BTN_myRcipes() {
        return upload_recipe_BTN_myRcipes;
    }

}
