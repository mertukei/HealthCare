package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinddoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);
        CardView exit = findViewById(R.id.cardfdback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(FinddoctorActivity.this,HomeActivity.class));
            }
        });

        CardView familyphysician = findViewById(R.id.cardfdfamilyphysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(FinddoctorActivity.this,DoctordetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });

        CardView dietician = findViewById(R.id.cardfddietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(FinddoctorActivity.this,DoctordetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardfddentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(FinddoctorActivity.this,DoctordetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardfdsurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(FinddoctorActivity.this,DoctordetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });
        CardView cardiologist = findViewById(R.id.cardfdcardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(FinddoctorActivity.this,DoctordetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });
    }
}