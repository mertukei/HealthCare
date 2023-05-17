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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule","","","","50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule","","","305"},
                    {"Vitamin B Complex Capsules","","","","539"},
                    {"Inlife Vitamin E Wheat Germ Oil  Capsules","","","","448"},
                    {"Dolo 650 Tablet","","","","30"},
                    {"Crocin 650 Advance Tablet ","","","","50"},
                    {"Strepsils Medicated Lozengens for sore Throat","","","","40"},
                    {"Tata 1mg Calcium + Vitamin D3","","","","30"},
                    {"Feronia -XT Tablet","","","","130"},

            };

    private String[] package_details = {
            "Building and keeping the bones strong\n" +
                "reducing fatigue/stress and muscular pains\n" +
                "boosting immunity and increasing resistance against infection",
            "chromium is an essential trace mineral that plays an immportant role in helping in insulin regulation ",
            "provide relief from vitamin B deficiencies\n" +
                    "helps in formation of red blood cells\n" +
                    "maintenance of healthy nervous system",
            "it promotes the health as well as body skin.\n" +
                    "it helps reduce skin blemish and pigmentation.\n" +
                    "it safequard the skin against UVA & UVB sun rays.",
            "Dolo 650 Tablets helps relieve pain and fever by blocking the release of certain of certain chemical",
            "helps relieve fever and bring down a high temperature\n" +
                    "suitable for people with heart condition or high pressure",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                    "provides a warm and comforting feeling during sore throat",
            "reduces the risk of calcium deficiency ,rickets,and osteoporosis\n" +
                    "promotes mobility and flexibility of joints",
            "helps to reduce the irons deficiency due to chronic blood loss or low intake of iron ",
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnback,btngotocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listviewBM);
        btnback = findViewById(R.id.btnBMback);
        btngotocart = findViewById(R.id.btnBMgotocart);

        btngotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
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
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}