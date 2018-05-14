package com.example.admin.simplified;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FourthActivity extends AppCompatActivity {
private     Spinner servicereq;
private     Spinner softwarereq;
private     EditText loc;
    private EditText business;
   private Button buttonid;

     private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);


        databaseReference= FirebaseDatabase.getInstance().getReference("services");

        servicereq=(Spinner)findViewById(R.id.spService);
        softwarereq=(Spinner)findViewById(R.id.spSoftware);
        loc=(EditText)findViewById(R.id.etLocation);
        business=(EditText)findViewById(R.id.etBusiness);
        buttonid=(Button)findViewById(R.id.btSubmit);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUiID();

            }
        });


    }

    private void setUiID(){

        String service=servicereq.getSelectedItem().toString();
        String soft=softwarereq.getSelectedItem().toString();
        String location=loc.getText().toString().trim();
        String businessid=business.getText().toString().trim();
        if(businessid.isEmpty()&&location.isEmpty()){

            Toast.makeText(this,"pls enter all details",Toast.LENGTH_SHORT) .show();
        }else{

            String id=databaseReference.push().getKey();
            Services services=new Services(id,service,soft,location,businessid);
            databaseReference.child(id).setValue(services);
            Toast.makeText(this,"service added",Toast.LENGTH_SHORT).show();



        }






    }





}
