package com.monishkumar.loginapp_webinar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText et_username, et_password;
    Button loginbutton;
    TextView goto_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        et_username = findViewById(R.id.username_et);
        et_password = findViewById(R.id.password_et);
        loginbutton = findViewById(R.id.login_bt);
        goto_signup = findViewById(R.id.signup_tv);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();

            }
        });

        goto_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginPage.this, SignupPage.class);
                startActivity(intent);
            }
        });

    }

    private void Login(){

        String login_username, login_password;

        login_username = et_username.getText().toString();
        login_password = et_password.getText().toString();

        SharedPreferences userdetails = getSharedPreferences("USER DETAILS", MODE_PRIVATE);

        String password = userdetails.getString(login_username,null);


        if (login_password.equals(password)){
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginPage.this, HomePage.class);
            intent.putExtra("Username", login_username);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Incorrect username/password", Toast.LENGTH_LONG).show();
        }
    }
}
