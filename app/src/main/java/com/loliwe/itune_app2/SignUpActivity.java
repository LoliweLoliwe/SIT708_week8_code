package com.loliwe.itune_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText name, username, password, confirmpassword;
    Button account;
    DbManager Db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.editText);
        username = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        confirmpassword = findViewById(R.id.editText4);
        account = findViewById(R.id.button);
        Db = new DbManager(this);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = name.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confpass = confirmpassword.getText().toString();

                if(fname.equals("") || user.equals("") || pass.equals("") || confpass.equals("")) {
                    Toast.makeText(SignUpActivity.this, "You have not completed all fields.", Toast.LENGTH_LONG).show();
                } else {
                    if(pass.equals(confpass)) {
                        Boolean checkuser = Db.checkname(user);
                        if(checkuser==false){
                            Boolean insert = Db.insertData(user, pass);
                            if(insert==true) {
                                Toast.makeText(SignUpActivity.this, "Your account has been successfully created", Toast.LENGTH_LONG).show();
                                Intent newIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                                startActivity(newIntent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Failed to create your account", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "The username already exists.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Information is missing or passwords are not matching.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}