package com.example.admin.simplified;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button  logout;


    private Button generateorder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        generateorder=(Button)findViewById(R.id.btOrder);

        firebaseAuth=FirebaseAuth.getInstance();
        logout=(Button)findViewById(R.id.btLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });

        generateorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(SecondActivity.this,ThirdActivity.class)));
            }
        });

    }
}
