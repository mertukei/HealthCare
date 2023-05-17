package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edtusername,edtemail,edtpassword,edtconfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtusername = findViewById(R.id.edttxttbfullname);
        edtemail = findViewById(R.id.edttxttbaddress);
        edtpassword = findViewById(R.id.edttxttbcontact);
        edtconfirm = findViewById(R.id.edttxttbpincode);
        btn = findViewById(R.id.btnltbbooking);
        tv = findViewById(R.id.rfooter);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtusername.getText().toString();
                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();
                String confirm = edtconfirm.getText().toString();
                database db = new database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill this field",Toast.LENGTH_SHORT).show();
                }else {
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                          Toast.makeText(getApplicationContext(),"Record inserted",Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(),"password must have a character,letter,digit and special symbol",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"password and confirm password did not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length() < 8){
            return false;
        }else{
            for (int p = 0; p< passwordhere.length();p++){
                if (Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r = 0; r< passwordhere.length();r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for (int s = 0; s< passwordhere.length();s++){
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f3==1)
                return true;
            return false;
        }
    }
}