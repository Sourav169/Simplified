package com.example.admin.simplified;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdActivity extends AppCompatActivity {
    private EditText clientname;
    private EditText address;
    private EditText pin;
    private EditText email;
    private EditText designation;
    private EditText phno;
    private Button submit;
    private Button compnayinform;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        databaseReference = FirebaseDatabase.getInstance().getReference("userProfile");
        setupUiViews();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        compnayinform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, FourthActivity.class));
            }
        });
    }

    private Boolean validate() {
        Boolean result = false;
        String clName = clientname.getText().toString();
        String Address = address.getText().toString();
        String Email = email.getText().toString();
        String Pincode = pin.getText().toString();
        String Designation = designation.getText().toString();
        if (clName.isEmpty() && Address.isEmpty() && Email.isEmpty()) {
            Toast.makeText(this, "pls enter all details", Toast.LENGTH_SHORT).show();
        } else {
            String id = databaseReference.push().getKey();
            UserProfile userProfile = new UserProfile(id, clName, Address, Email, Pincode, Designation);
            databaseReference.child(id).setValue(userProfile);
            Toast.makeText(this, " added", Toast.LENGTH_SHORT).show();

        }
        return result;
    }


    private void setupUiViews() {
        clientname = (EditText) findViewById(R.id.etClname);
        address = (EditText) findViewById(R.id.etAddress);
        email = (EditText) findViewById(R.id.etEmailad);
        phno = (EditText) findViewById(R.id.etPh);
        pin = (EditText) findViewById(R.id.etPin);
        designation = (EditText) findViewById(R.id.etDesign);
        submit = (Button) findViewById(R.id.btSubmit);
        compnayinform = (Button) findViewById(R.id.btCompany);
    }
}
