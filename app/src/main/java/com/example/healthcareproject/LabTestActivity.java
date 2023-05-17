package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1 : Full Body Checkup","","","","600"},
                    {"Package 2  : Blood Glucose Fasting","","","","299"},
                    {"Package 3  : Covid-19 Antibody","IgG","","","","899"},
                    {"Package 4  : Thyroid Check","","","","400"},
                    {"Package 5  : Immunity Check","","","","699"},
            };
    private String[]package_details = {
            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbAIc\n" +
                    "Iron studies\n" +
                    "Kidney Function  Test\n" +
                    "LDH Lactate Dehydrogenase, serum\n" +
                    "Lipid Profile\n" +
                    "Liver function test",
            "Blood Glucose Fasting",
            "Covid-19 Antibody - IgG",
            "Thyroid Profile-Total(T3,T4 & TSH Ultra-sensitive)",
            "Complete Hemogram\n" +
                    "CRP (C Reactive  protein) quantitatives, serum\n" +
                    "iron studies\n" +
                    "kidney function test\n" +
                    "vitamin D Total-25 hydroxy\n" +
                    "liver function test\n" +
                    "lipid profile"
    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btngotocart,btnback;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btngotocart = findViewById(R.id.btnLTgotocart);
        btnback = findViewById(R.id.btnLTback);
        listView = findViewById(R.id.listviewLT);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"$");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
        btngotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });

    }
}