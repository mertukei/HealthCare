package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvpackagename,tvtotalcost;
    EditText eddetails;
    Button btnaddtocart,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvpackagename = findViewById(R.id.txtLTDpackagename);
        tvtotalcost = findViewById(R.id.txtLTDtotalcost);
        eddetails = findViewById(R.id.edtLTDmultilines);
        btnaddtocart = findViewById(R.id.btnLTDgotocart);
        btnback = findViewById(R.id.btnLTDback);


        eddetails.setKeyListener(null);

        Intent intent = getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        eddetails.setText(intent.getStringExtra("text2"));
        tvtotalcost.setText("total cost:"+intent.getStringExtra("text1")+"$");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });
        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvpackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                database db = new database(getApplicationContext(),"healthcare",null,1);
                if(db.checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"product already add",Toast.LENGTH_SHORT).show();
                }else{
                    db.addcart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"record inserted to cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
                }
            }
        });
    }
}