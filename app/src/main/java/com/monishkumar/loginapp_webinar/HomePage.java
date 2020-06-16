package com.monishkumar.loginapp_webinar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    TextView title;
    Button deleteacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        title = findViewById(R.id.title_tv);
        deleteacc = findViewById(R.id.delete_bt);

        final String username = getIntent().getStringExtra("Username");

        title.setText("Hello " + username + "!");

        deleteacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences userdetails = getSharedPreferences("USER DETAILS",MODE_PRIVATE);
                SharedPreferences.Editor editor = userdetails.edit();

                editor.remove(username);
                editor.commit();

                Toast.makeText(HomePage.this, "Acoount Deleted Successfully!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomePage.this, LoginPage.class);
                startActivity(intent);

            }
        });

    }
}
