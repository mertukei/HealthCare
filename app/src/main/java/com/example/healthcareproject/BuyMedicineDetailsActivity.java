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

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvpackagename,tvtotalcost;
    EditText edtdetails;
    Button btnBack,btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvpackagename = findViewById(R.id.txtbmdpackagename);
        edtdetails = findViewById(R.id.edtmbmdmultilines);
        edtdetails.setKeyListener(null);
        tvtotalcost = findViewById(R.id.txtbmdtotalcost);
        btnAddToCart = findViewById(R.id.btnbmdgotocart);
        btnBack = findViewById(R.id.btnbmdback);

        Intent intent=getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        edtdetails.setText(intent.getStringExtra("text2"));
        tvtotalcost.setText("Total Cost :"+intent.getStringExtra("text3")+"$");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvpackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                database db = new database(getApplicationContext(),"healthcare",null,1);

                if(db.checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"product already add",Toast.LENGTH_SHORT).show();
                }else{
                    db.addcart(username,product,price,"medicine");
                    Toast.makeText(getApplicationContext(),"record inserted to cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
                }
            }
        });
    }
}