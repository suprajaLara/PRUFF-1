package com.Pruff.pruff;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.pruff.R;

import java.util.concurrent.TimeUnit;

public class OneTimePassword extends AppCompatActivity {

    private Button verifyOTP;
    private EditText getOTP;
    private FirebaseAuth auth;
    String phoneNumber,email;
    String profession,highQual,stream,field;
    String gender,name,mobileName,city,tongue,frequent,imei;
    String s1,s2,s3,s4;
    String Password;
    String uid;
    FirebaseUser user;
    private DatabaseReference mRef;
    //PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_password);

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
        s1 = i.getStringExtra("tourORback");
        s2 = i.getStringExtra("introORextro");
        s3 = i.getStringExtra("handyORdoit");
        s4 = i.getStringExtra("indieORmain");
        phoneNumber = "+91"+i.getStringExtra("phoneNumber");
        email = i.getStringExtra("email");

        verifyOTP = findViewById(R.id.verify_otp);
        getOTP = findViewById(R.id.otp_get);

//        StartFirebaseLogin();
        auth = FirebaseAuth.getInstance();

//        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//                Toast.makeText(OneTimePassword.this, "verification completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(OneTimePassword.this, "verification failed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
//                super.onCodeSent(s,forceResendingToken);
//                verificationCode = s;
//                Toast.makeText(getApplicationContext(),"Code Sent",Toast.LENGTH_SHORT).show();
//            }
//
//        };

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                OneTimePassword.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        Toast.makeText(OneTimePassword.this, "verification completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(OneTimePassword.this, "verification failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
                        super.onCodeSent(s,forceResendingToken);
                        verificationCode = s;
                        Toast.makeText(getApplicationContext(),"Code Sent",Toast.LENGTH_SHORT).show();
                    }

                });


        verifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String otp = getOTP.getText().toString();
                Password = "PruffAppX";

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode,otp);

                String s = credential.getSmsCode();
                if (s.equals(otp))
                {
                    auth.createUserWithEmailAndPassword(email,Password)
                            .addOnCompleteListener(OneTimePassword.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(OneTimePassword.this, "Authentication failed.||Incorrect OTP" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(OneTimePassword.this, "Authentication successful.",Toast.LENGTH_SHORT).show();

                                        mRef = FirebaseDatabase.getInstance().getReference();
                                        uid = mRef.push().getKey();
                                        UserDetails ud = new UserDetails(name,gender,city,tongue,mobileName,frequent,imei,profession,highQual,stream,field,s1,s2,s3,s4,phoneNumber,email,Password);

                                        mRef.child("Users").child(uid).setValue(ud);

                                        Intent i = new Intent(OneTimePassword.this, WaitPage.class);
                                        startActivity(i);
                                        finish();
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(OneTimePassword.this,"Enter otp",Toast.LENGTH_SHORT).show();
                }
            }
        });



//        verifyEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                user = FirebaseAuth.getInstance().getCurrentUser();
//                    user.sendEmailVerification().addOnCompleteListener(OneTimePassword.this, new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(OneTimePassword.this, "Verification email sent to " + user.getEmail(), Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(OneTimePassword.this, "Failed to send verification email.", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                        }
//                    });
//            }
//        });

//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                user = FirebaseAuth.getInstance().getCurrentUser();
//                if(user.isEmailVerified()){
//                    mRef = FirebaseDatabase.getInstance().getReference();
//                    uid = mRef.push().getKey();
//                    UserDetails ud = new UserDetails(name,gender,city,tongue,mobileName,frequent,imei,profession,highQual,stream,field,s1,s2,s3,s4,phoneNumber,email,Password);
//
//                    mRef.child("Users").child(uid).setValue(ud);
//
//                    startActivity(new Intent(OneTimePassword.this, WaitPage.class));
//                    auth.signOut();
//                    finish();}
//                    else{
//                    Toast.makeText(OneTimePassword.this,"Please verify email id",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });

    }

//    private void StartFirebaseLogin() {
//        auth = FirebaseAuth.getInstance();
//        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//                Toast.makeText(OneTimePassword.this, "verification completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(OneTimePassword.this, "verification failed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
//                super.onCodeSent(s,forceResendingToken);
//                verificationCode = s;
//                Toast.makeText(getApplicationContext(),"Code Sent",Toast.LENGTH_SHORT).show();
//            }
//
//        };
//    }
}
