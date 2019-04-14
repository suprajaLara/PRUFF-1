package com.Pruff.pruff;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.pruff.R;

public class Register extends AppCompatActivity {

    private EditText fName,lName,Phone,Dob,Email_add,Pass,RePass;
    private Button next,alreadyRegister;
    //FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //auth = FirebaseAuth.getInstance();

        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        Phone = findViewById(R.id.Phone);
        Email_add = findViewById(R.id.EmailIdRegister);
        next = findViewById(R.id.next);
        alreadyRegister = findViewById(R.id.alreadyRegistered);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        alreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity.class));
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fname = fName.getText().toString();
                String Lname = lName.getText().toString();
                String Phoneno = "+91"+Phone.getText().toString();
                String email = Email_add.getText().toString();

                if(TextUtils.isEmpty(Fname))
                {
                    Toast.makeText(getApplicationContext(),"Enter First Name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Lname))
                {
                    Toast.makeText(getApplicationContext(),"Enter Last Name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Phoneno))
                {
                    Toast.makeText(getApplicationContext(),"Enter Phone number",Toast.LENGTH_SHORT).show();
                    return;
                }


                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent i = new Intent(Register.this,OneTimePassword.class);
                i.putExtra("PhoneNum",Phoneno);
                i.putExtra("firstName",Fname);
                i.putExtra("lastName",Lname);
                i.putExtra("EMAil",email);
                startActivity(i);

            }
        });

    }
}

