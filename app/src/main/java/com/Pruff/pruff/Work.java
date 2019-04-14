package com.Pruff.pruff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.pruff.R;

public class Work extends AppCompatActivity {

    Spinner profS,HighS,StreamS,fieldS;
    ArrayAdapter<CharSequence> profA,HighA,StreamA,fieldA;
    TextView tv1,tv2,tv3,tv4;
    String profession,highQual,stream,field;
    String gender,name,mobileName,city,tongue,frequent,imei;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        gender = i.getStringExtra("gender");
        city = i.getStringExtra("city");
        tongue = i.getStringExtra("mTongue");
        mobileName = i.getStringExtra("mobileName");
        frequent = i.getStringExtra("freq");
        imei = i.getStringExtra("imei");

        next = findViewById(R.id.work_next);

        //Intent intent = getIntent();
        profS = findViewById(R.id.profession_spinner);
        HighS = findViewById(R.id.highQual_spinner);
        StreamS = findViewById(R.id.stream_spinner);
        fieldS = findViewById(R.id.field_spinner);

        profA = ArrayAdapter.createFromResource(Work.this,R.array.profession_list,android.R.layout.select_dialog_item);
        profS.setAdapter(profA);

        HighA = ArrayAdapter.createFromResource(Work.this,R.array.highQual_list,android.R.layout.select_dialog_item);
        HighS.setAdapter(HighA);

        StreamA = ArrayAdapter.createFromResource(Work.this,R.array.strream_list,android.R.layout.select_dialog_item);
        StreamS.setAdapter(StreamA);

        fieldA = ArrayAdapter.createFromResource(Work.this,R.array.field_list,android.R.layout.select_dialog_item);
        fieldS.setAdapter(fieldA);

        profS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv1  = (TextView) view;
                tv1.setTextColor(getResources().getColor(R.color.gray));
                tv1.setTextSize(15);
                profession = profS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        HighS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv2  = (TextView) view;
                tv2.setTextColor(getResources().getColor(R.color.gray));
                tv2.setTextSize(15);
                highQual = HighS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        StreamS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv3  = (TextView) view;
                tv3.setTextColor(getResources().getColor(R.color.gray));
                tv3.setTextSize(15);
                stream = StreamS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fieldS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv4  = (TextView) view;
                tv4.setTextColor(getResources().getColor(R.color.gray));
                tv4.setTextSize(15);
                field = fieldS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(profession)){
                    tv1.setError("Select profession!");
                    Toast.makeText(Work.this,"Check details!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(highQual)){
                    tv2.setError("Select Qualification!");
                    Toast.makeText(Work.this,"Check details!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(stream)){
                    tv3.setError("Select Stream!");
                    Toast.makeText(Work.this,"Check details!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(field)){
                    tv4.setError("Select Field of study!");
                    Toast.makeText(Work.this,"Check details!",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(Work.this,Philos.class);
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
                startActivity(i);
                finish();

            }
        });

    }
}
