package com.Pruff.pruff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.pruff.R;

public class About extends AppCompatActivity {

    Spinner genderS,mTongueS,freqS;
    ArrayAdapter<CharSequence> adapter,mTonAdapter,FreqAdapter;
    String gender,name,mobileName,city,tongue,frequent,imei;
    EditText NameE,CityE,mnE,imeiE;
    TextView tv1,tv2,tv3;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        NameE = findViewById(R.id.firName);
        CityE = findViewById(R.id.city_spinner);
        mnE = findViewById(R.id.mobile);
        imeiE = findViewById(R.id.imei);
        next = findViewById(R.id.about_next);

        genderS = findViewById(R.id.gender_spinner);
        mTongueS = findViewById(R.id.mother_spinner);
        freqS = findViewById(R.id.frequent_spinner);

        adapter = ArrayAdapter.createFromResource(About.this,R.array.gender,android.R.layout.select_dialog_item);
        genderS.setAdapter(adapter);

        mTonAdapter = ArrayAdapter.createFromResource(About.this,R.array.motherTongue,android.R.layout.select_dialog_item);
        mTongueS.setAdapter(mTonAdapter);

        FreqAdapter = ArrayAdapter.createFromResource(About.this,R.array.frequentUse,android.R.layout.select_dialog_item);
        freqS.setAdapter(FreqAdapter);

        genderS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv1  = (TextView) view;
                tv1.setTextColor(getResources().getColor(R.color.gray));
                tv1.setTextSize(15);
                gender = genderS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mTongueS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv2  = (TextView) view;
                tv2.setTextColor(getResources().getColor(R.color.gray));
                tv2.setTextSize(15);
                tongue = mTongueS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        freqS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tv3  = (TextView) view;
                tv3.setTextColor(getResources().getColor(R.color.gray));
                tv3.setTextSize(15);
                frequent = freqS.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = NameE.getText().toString();
                mobileName = mnE.getText().toString();
                city = CityE.getText().toString();
                imei = imeiE.getText().toString();

                if(TextUtils.isEmpty(name))
                {
                    NameE.setError("Enter name!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(gender))
                {
                    tv1.setError("Select gender!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(city))
                {
                    CityE.setError("Enter city!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(tongue))
                {
                    tv2.setError("select mother tongue!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(mobileName))
                {
                    mnE.setError("Enter mobile name!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(frequent))
                {
                    tv3.setError("select percentage!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(imei))
                {
                    imeiE.setError("Enter imei!");
                    Toast.makeText(About.this,"Check details!!",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(About.this,Work.class);
                i.putExtra("name",name);
                i.putExtra("gender",gender);
                i.putExtra("city",city);
                i.putExtra("mTongue",tongue);
                i.putExtra("mobileName",mobileName);
                i.putExtra("freq",frequent);
                i.putExtra("imei",imei);
                startActivity(i);
                finish();

            }
        });

    }
}

//        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item) {
//
//            @Override
//            public boolean isEnabled(int position) {
//                // TODO Auto-generated method stub
//                if (position == 0) {
//                    return false;
//                }
//                return true;
//            }
//
//            // Change color item
//            @Override
//            public View getDropDownView(int position, View convertView,
//                                        ViewGroup parent) {
//                // TODO Auto-generated method stub
//                View mView = super.getDropDownView(position, convertView, parent);
//                TextView mTextView = (TextView) mView;
//                if (position == 0) {
//                    mTextView.setTextColor(Color.GRAY);
//                } else {
//                    mTextView.setTextColor(Color.BLACK);
//                }
//                return mView;
//
//            }
//
//        };
//
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner1.setAdapter(adapter);
//
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(position!=0){
//                    s1 = spinner1.getItemAtPosition(position).toString();}
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//}




//        adapter = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.select_dialog_item);
//        adapter = new ArrayAdapter<>(About.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.gender));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner1.setAdapter(adapter);
//
//        spinner.setEnabled(false);
//
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                TextView tv = (TextView) view;
//                if(position!=0)
//                {
//                    s1 = spinner1.getItemAtPosition(position).toString();
//                }
//                else
//                {
//                    tv.setError("Select Gender!");
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
