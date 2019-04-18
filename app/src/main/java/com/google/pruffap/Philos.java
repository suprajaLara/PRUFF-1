package com.google.pruffap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Philos extends AppCompatActivity {

    Button next,apple,androide,root,nonroot,finger,nonfinger,backup,not;
    String profession,highQual,stream,field;
    String gender,name,mobileName,city,tongue,frequent,imei;
    String s1,s2,s3,s4;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philos);

        //tv = findViewById(R.id.tv);

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

        apple = findViewById(R.id.apple);
        androide = findViewById(R.id.android);
        root = findViewById(R.id.root);
        nonroot = findViewById(R.id.nonroot);
        finger = findViewById(R.id.finger);
        nonfinger = findViewById(R.id.nonfinger);
        backup = findViewById(R.id.backup);
        not = findViewById(R.id.not);
        next = findViewById(R.id.philos_next);

        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apple.setBackgroundResource(R.drawable.btn3);
                androide.setBackgroundResource(R.drawable.btn2);
                s1 = apple.getText().toString();
            }
        });
        androide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apple.setBackgroundResource(R.drawable.btn);
                androide.setBackgroundResource(R.drawable.btn3);
                s1 = androide.getText().toString();
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setBackgroundResource(R.drawable.btn3);
                nonroot.setBackgroundResource(R.drawable.btn2);
                s2 = root.getText().toString();
            }
        });
        nonroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setBackgroundResource(R.drawable.btn);
                nonroot.setBackgroundResource(R.drawable.btn3);
                s2 = nonroot.getText().toString();
            }
        });
        finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finger.setBackgroundResource(R.drawable.btn3);
                nonfinger.setBackgroundResource(R.drawable.btn2);
                s3 = finger.getText().toString();
            }
        });
        nonfinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finger.setBackgroundResource(R.drawable.btn);
                nonfinger.setBackgroundResource(R.drawable.btn3);
                s3 = nonfinger.getText().toString();
            }
        });
        backup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backup.setBackgroundResource(R.drawable.btn3);
                not.setBackgroundResource(R.drawable.btn2);
                s4 = backup.getText().toString();
            }
        });
        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backup.setBackgroundResource(R.drawable.btn);
                not.setBackgroundResource(R.drawable.btn3);
                s4 = not.getText().toString();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(s1))
                {
                    Toast.makeText(Philos.this,"Answer if apple or android",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(s2))
                {
                    Toast.makeText(Philos.this,"Answer if root or no",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(s3))
                {
                    Toast.makeText(Philos.this,"Answer if fingerprint or no",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(s4))
                {
                    Toast.makeText(Philos.this,"Answer if backup or no",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(Philos.this,FinalRegister.class);
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
                startActivity(i);
                finish();

            }
        });
    }
}
