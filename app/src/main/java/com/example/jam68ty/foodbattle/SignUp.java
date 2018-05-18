package com.example.jam68ty.foodbattle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Button checkAccount, registerButton;
    EditText myAccount, signUpEmail, signUpPassword, checkPassword;
    TextView logInDirect;
    ConstraintLayout myLayout;


    private FirebaseAuth auth;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        checkAccount = findViewById(R.id.check_account);
        registerButton = findViewById(R.id.register_button);
        myAccount = findViewById(R.id.account);
        signUpEmail = findViewById(R.id.sign_up_email);
        signUpPassword = findViewById(R.id.sign_up_password);
        checkPassword = findViewById(R.id.check_password);
        logInDirect = findViewById(R.id.log_in_direct);

        checkAccount.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        logInDirect.setOnClickListener(this);


        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.log_in_direct) {
            startActivity(new Intent(SignUp.this, LoginActivity.class));
            finish();
        }
        else if(view.getId()==R.id.register_button){
signUpUser(signUpEmail.getText().toString(),signUpPassword.getText().toString());

        }
    }

    private void signUpUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    snackbar=Snackbar.make(myLayout,"失敗 "+task.getException(),Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
                else {
                    snackbar=Snackbar.make(myLayout,"註冊成功: ",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });}
}
