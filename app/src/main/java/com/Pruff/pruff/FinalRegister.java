package com.Pruff.pruff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.pruff.R;

public class FinalRegister extends AppCompatActivity {

    EditText phone,email;
    String phoneNumber,Email;
    String profession,highQual,stream,field;
    String gender,name,mobileName,city,tongue,frequent,imei;
    String s1,s2,s3,s4;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_register);

        phone = findViewById(R.id.phone);
        email = findViewById(R.id.Email);
        next = findViewById(R.id.final_next);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        gender = i.getStringExtra("gender");
        city = i.getStringExtra("city");
        tongue = i.getStringExtra("mTongue");
        mobileName = i.getStringExtra("mobileName");
        frequent = i.getStringExtra("freq");
        imei = i.getStringExtra("imei");
        profession = i.getStringExtra("profession");
        highQual = i.getStringExtra("qualification");
        stream = i.getStringExtra("stream");
        field = i.getStringExtra("field");
        s1 = i.getStringExtra("appleORnot");
        s2 = i.getStringExtra("rootORnot");
        s3 = i.getStringExtra("fingerORnot");
        s4 = i.getStringExtra("backORnot");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = phone.getText().toString();
                Email = email.getText().toString();

                if(TextUtils.isEmpty(phoneNumber)){
                    phone.setError("Enter phone number");
                    return;
                }
                if (TextUtils.isEmpty(Email)){
                    email.setError("Enter email id");
                    return;
                }
                Intent i = new Intent(FinalRegister.this,OneTimePassword.class);
                i.putExtra("name",name);
                i.putExtra("gender",gender);
                i.putExtra("city",city);
                i.putExtra("mTongue",tongue);
                i.putExtra("mobileName",mobileName);
                i.putExtra("freq",frequent);
                i.putExtra("imei",imei);
                i.putExtra("profession",profession);
                i.putExtra("qualification",highQual);
                i.putExtra("stream",stream);
                i.putExtra("field",field);
                i.putExtra("appleORnot",s1);
                i.putExtra("rootORnot",s2);
                i.putExtra("fingerORnot",s3);
                i.putExtra("backORnot",s4);
                i.putExtra("phoneNumber",phoneNumber);
                i.putExtra("email",Email);
                startActivity(i);
                finish();
            }
        });

    }
}
