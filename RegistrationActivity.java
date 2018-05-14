package com.example.admin.simplified;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setupUiViews();
        firebaseAuth = FirebaseAuth.getInstance();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegistrationActivity.this, "registraion successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));


                            } else {
                                Toast.makeText(RegistrationActivity.this, "registraion failed", Toast.LENGTH_SHORT).show();

                            }


                        }
                    });

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });


    }

    private void setupUiViews() {

        userName = (EditText) findViewById(R.id.etName);
        userEmail = (EditText) findViewById(R.id.etEmail);
        userPassword = (EditText) findViewById(R.id.etPassword);
        regButton = (Button) findViewById(R.id.btSignup);
        login = (TextView) findViewById(R.id.tvUserlogin);


    }

    private Boolean validate() {

        Boolean result = false;

        String Name = userName.getText().toString();
        String Password = userPassword.getText().toString();
        String Email = userEmail.getText().toString();

        if (Name.isEmpty() && Password.isEmpty() && Email.isEmpty()) {

            Toast.makeText(this, "pls enter all details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;

        }
        return result;


    }


}
