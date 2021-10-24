package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    public final static String TAG= "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser() != null){
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick signup button");
                goSignupActivity();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                //Toast.makeText(LoginActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);
            }
        });
    }

        private void loginUser(String username, String password){
            Log.i(TAG, "Attempting to login user" + username);
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, com.parse.ParseException e) {

                    if (e != null)
                    {
                        Log.e(TAG, "Issue with login", e);
                        return;
                    }
                    goMainActivity();
                    Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT ).show();

                }
            });
        }

        private void goMainActivity() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

    private void goSignupActivity() {
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
        finish();
    }


}