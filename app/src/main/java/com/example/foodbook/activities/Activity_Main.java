package com.example.foodbook.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodbook.GlobalState;
import com.example.foodbook.boundary.UserBoundary;
import com.example.foodbook.model.MainData;
import com.example.foodbook.rest.RestClient;
import com.example.foodbook.rest.RestInterface;
import com.example.foodbook.utils.AppManager;
import com.example.foodbook.R;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Activity_Main extends AppCompatActivity implements View.OnClickListener {
    private static final String A_TAG = "A_tag";
    private AppManager appManager;
    private Button login_BTN;
    private Button signup_manualy_BTN;
    private EditText login_email_LBL;
    private EditText login_password_LBL;
    private String entered_email;
    private String entered_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        appManager = new AppManager(this);
        appManager.findViewsLogin(this);
        initViews();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_BTN:
                loginUser();
                break;
            case R.id.signup_manualy_BTN:
                startActivity(new Intent(Activity_Main.this,Activity_SignUp.class));
                break;
        }
    }


    private void initViews(){
        login_BTN = appManager.getLogin_BTN();
        signup_manualy_BTN = appManager.getSignup_manualy_BTN();
        login_email_LBL = appManager.getLogin_email_LBL();
        login_password_LBL= appManager.getLogin_password_LBL();
        login_BTN.setOnClickListener(this);
        signup_manualy_BTN.setOnClickListener(this);
    }


    private void loginUser() {
        entered_email = login_email_LBL.getText().toString();
        entered_pass = login_password_LBL.getText().toString();
        if (entered_email.isEmpty() || entered_pass.isEmpty()) {
            makeToast("Email or password is empty, please fill in the empty fields!");
            return;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(entered_email).matches()) {
            Toast.makeText(getBaseContext(),"Please provide valid email!",
                    Toast.LENGTH_LONG).show();
            return;
        }else {
            RestInterface restInterface = RestClient.createRetrofit().create(RestInterface.class);
            Call<UserBoundary> callLogin = restInterface.loginUserAndRetrieve("2022A.Roei.Berko", entered_email);
            callLogin.enqueue(new Callback<UserBoundary>() {
                @Override
                public void onResponse(Call<UserBoundary> call, Response<UserBoundary> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Something wrong, Code: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }

                    GlobalState.getLoggedUser().setLoggedUser(response.body());

                    Intent myIntent = new Intent(Activity_Main.this, Activity_MyFeed.class);
                    startActivity(myIntent);
                }

                @Override
                public void onFailure(Call<UserBoundary> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something wrong check it", Toast.LENGTH_LONG).show();
                }
            });
        }
    }



    void makeToast(String string){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),string,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}

