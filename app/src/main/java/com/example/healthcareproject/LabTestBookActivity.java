package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    EditText edtname,edtaddress,edtcontact,edtpincode;
    Button btnbooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edtname = findViewById(R.id.edttxtLTBfullname);
        edtaddress = findViewById(R.id.edttxtLTBaddress);
        edtcontact = findViewById(R.id.edttxtLTBcontact);
        edtpincode = findViewById(R.id.edttxtLTBpincode);
        btnbooking = findViewById(R.id.btnLTBbooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharepreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharepreferences.getString("username","").toString();
                database db = new database(getApplicationContext(),"healthcare",null,1);
                db.addorder(username,edtname.getText().toString(),edtaddress.getText().toString(),edtcontact.getText().toString(),Integer.parseInt(edtpincode.getText().toString()),date.toString(),"", Float.parseFloat(price[1].toString()),"lab");
                db.removecart(username,"lab");
                Toast.makeText(getApplicationContext(),"your booking is  done successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });

    }
}