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

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edtname,edtaddress,edtcontact,edtpincode;
    Button btnbooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);
        edtname = findViewById(R.id.edttxtbmbfullname);
        edtaddress = findViewById(R.id.edttxtbmbaddress);
        edtcontact = findViewById(R.id.edttxtbmbcontact);
        edtpincode = findViewById(R.id.edttxtbmbpincode);
        btnbooking = findViewById(R.id.btnbmbbooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharepreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharepreferences.getString("username","").toString();
                database db = new database(getApplicationContext(),"healthcare",null,1);
                db.addorder(username,edtname.getText().toString(),edtaddress.getText().toString(),edtcontact.getText().toString(),Integer.parseInt(edtpincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removecart(username,"medicine");
                Toast.makeText(getApplicationContext(),"your booking is  done successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));
            }
        });

    }
}