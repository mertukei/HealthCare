package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctordetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Emmanuel kitongin","Hospital address : Agha khan","Exp : 5years","Mobile No:0710550123","600"},
                    {"Doctor Name : Martin Krop","Hospital address : Kenyatta","Exp : 15years","Mobile No:0726550125","800"},
                    {"Doctor Name : Victor Mutinda","Hospital address : Eldoret","Exp : 4years","Mobile No:0714550110","500"},
                    {"Doctor Name : Ellah Danniela","Hospital address : Chiromo","Exp : 10years","Mobile No:0716550124","700"},
                    {"Doctor Name : Diana Chemtkaa","Hospital address : Karen","Exp : 6years","Mobile No:0716550120","900"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Emmanuel kitongin","Hospital address : Agha khan","Exp : 5years","Mobile No:0710550123","600"},
                    {"Doctor Name : Martin Krop","Hospital address : Kenyatta","Exp : 15years","Mobile No:0726550125","800"},
                    {"Doctor Name : Victor Mutinda","Hospital address : Eldoret","Exp : 4years","Mobile No:0714550110","500"},
                    {"Doctor Name : Ellah Danniela","Hospital address : Chiromo","Exp : 10years","Mobile No:0716550124","700"},
                    {"Doctor Name : Diana Chemtkaa","Hospital address : Karen","Exp : 6years","Mobile No:0716550120","900"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Emmanuel kitongin","Hospital address : Agha khan","Exp : 5years","Mobile No:0710550123","600"},
                    {"Doctor Name : Martin Krop","Hospital address : Kenyatta","Exp : 15years","Mobile No:0726550125","800"},
                    {"Doctor Name : Victor Mutinda","Hospital address : Eldoret","Exp : 4years","Mobile No:0714550110","500"},
                    {"Doctor Name : Ellah Danniela","Hospital address : Chiromo","Exp : 10years","Mobile No:0716550124","700"},
                    {"Doctor Name : Diana Chemtkaa","Hospital address : Karen","Exp : 6years","Mobile No:0716550120","900"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Emmanuel kitongin","Hospital address : Agha khan","Exp : 5years","Mobile No:0710550123","600"},
                    {"Doctor Name : Martin Krop","Hospital address : Kenyatta","Exp : 15years","Mobile No:0726550125","800"},
                    {"Doctor Name : Victor Mutinda","Hospital address : Eldoret","Exp : 4years","Mobile No:0714550110","500"},
                    {"Doctor Name : Ellah Danniela","Hospital address : Chiromo","Exp : 10years","Mobile No:0716550124","700"},
                    {"Doctor Name : Diana Chemtkaa","Hospital address : Karen","Exp : 6years","Mobile No:0716550120","900"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Emmanuel kitongin","Hospital address : Agha khan","Exp : 5years","Mobile No:0710550123","600"},
                    {"Doctor Name : Martin Krop","Hospital address : Kenyatta","Exp : 15years","Mobile No:0726550125","800"},
                    {"Doctor Name : Victor Mutinda","Hospital address : Eldoret","Exp : 4years","Mobile No:0714550110","500"},
                    {"Doctor Name : Ellah Danniela","Hospital address : Chiromo","Exp : 10years","Mobile No:0716550124","700"},
                    {"Doctor Name : Diana Chemtkaa","Hospital address : Karen","Exp : 6years","Mobile No:0716550120","900"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordetails);
        tv = findViewById(R.id.txtddtitle);
        btn = findViewById(R.id.btnddback);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family physician")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctordetailsActivity.this,FinddoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"$");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listviewdd);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctordetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}