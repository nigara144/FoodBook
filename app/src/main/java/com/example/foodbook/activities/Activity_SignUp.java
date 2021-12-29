package com.example.foodbook.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodbook.model.MainData;
import com.example.foodbook.rest.RestClient;
import com.example.foodbook.rest.RestInterface;
import com.example.foodbook.utils.AppManager;
import com.example.foodbook.R;
import com.example.foodbook.objects.Recipe;
import com.example.foodbook.objects.User;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Activity_SignUp extends AppCompatActivity {
    private static final String A_TAG = "A_tag";
    private static final String EMAIL = "email";
    private static final String UNAME = "userName";
    private ArrayList<Recipe> userRecipes;
    private ArrayList<Recipe> wishList;
    private AppManager appManager;
    //    private FirebaseAuth mAuth;
    private Button signup_BTN;
    private ImageButton back_button;
    private EditText signUp_uName_LBL;
    private EditText signUp_email_LBL;
    private EditText signUp_password_LBL;
    private EditText verify_password_LBL;
    private String uName;
    private String email;
    private String password;
    private String password_ver;
    private MainData.UserRoleEntityEnum role;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);
        appManager = new AppManager(this);
        appManager.findViewsSignUp(this);
//        mAuth = FirebaseAuth.getInstance();
        initViews();
    }

    private void initViews() {
        signup_BTN = appManager.getSignup_BTN();
        signUp_uName_LBL = appManager.getSignUp_uName_LBL();
        signUp_email_LBL = appManager.getSignUp_email_LBL();
        signUp_password_LBL = appManager.getSignUp_password_LBL();
        verify_password_LBL = appManager.getVerify_password_LBL();
        back_button = appManager.getBack_button();
        signup_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_SignUp.this, Activity_Main.class);
                startActivity(myIntent);
                finish();
            }
        });
    }

    private void signUpUser() {
        uName = signUp_uName_LBL.getText().toString();
        email = signUp_email_LBL.getText().toString();
        email = "2022A.Roei.Berko;" + email;
        password = signUp_password_LBL.getText().toString();
        role = MainData.UserRoleEntityEnum.PLAYER;
        if (uName.isEmpty()) {
            signUp_uName_LBL.setError("UserName is Required");
            signUp_uName_LBL.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            signUp_email_LBL.setError("Email is Required");
            signUp_email_LBL.requestFocus();
            return;
        }

        RestInterface restInterface = RestClient.createRetrofit().create(RestInterface.class);
        Call<MainData> call = restInterface.createNewUser(new MainData(email, role, uName, password));
        call.enqueue(new Callback<MainData>() {
            @Override
            public void onResponse(Call<MainData> call, Response<MainData> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Something wrong, Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<MainData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something wrong check it", Toast.LENGTH_LONG).show();
                Log.d("ptt", t.getMessage());
            }
        });


    }

}
