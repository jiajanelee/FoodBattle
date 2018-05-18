package com.example.jam68ty.foodbattle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText memail, mpassword;
    TextView msignup;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.log_in_button);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        msignup = findViewById(R.id.sign_up);

        login.setOnClickListener(this);
        msignup.setOnClickListener(this);

        //init firebase auth
        auth = FirebaseAuth.getInstance();

        //check already session , if ok->Dashboard

    }

    public void onClick(View View) {


    }

}
