package com.loliwe.itune_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button signin, account;
    DbManager Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTxt1);
        password = findViewById(R.id.editTxt2);
        signin = findViewById(R.id.button1);
        account = findViewById(R.id.button2);
        Db = new DbManager(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "You have not completed all fields.", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkuser = Db.confirmnamepasswd(user,pass);
                    if (checkuser == true) {
                        Toast.makeText(MainActivity.this, "Successfully login", Toast.LENGTH_LONG).show();
                        Intent newIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(newIntent);
                    } else {
                        Toast.makeText(MainActivity.this, "Information is missing or double-check your details for errors!!! ", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(newIntent);
            }
        });

    }
}