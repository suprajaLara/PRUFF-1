package com.google.pruff;

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
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OneTimePassword extends AppCompatActivity {

    private Button verifyOTP, resendOTP;
    private EditText getOTP;
    private FirebaseAuth auth;
    String FirstName,LastName,PhoneNumber,Dateob,EmailId,Password;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_password);

        FirstName = getIntent().getStringExtra("firstName");
        LastName = getIntent().getStringExtra("lastName");
        PhoneNumber = getIntent().getStringExtra("PhoneNum");
        Dateob = getIntent().getStringExtra("DateOB");
        EmailId = getIntent().getStringExtra("EMAil");
        Password = getIntent().getStringExtra("password");

        verifyOTP = findViewById(R.id.verify_otp);
        resendOTP = findViewById(R.id.resend_otp);
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
                PhoneNumber,
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

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode,otp);

                String s = credential.getSmsCode();
                if (s.equals(otp))
                {
                    auth.createUserWithEmailAndPassword(EmailId,Password)
                            .addOnCompleteListener(OneTimePassword.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(OneTimePassword.this, "Authentication failed.||Incorrect OTP" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        startActivity(new Intent(OneTimePassword.this, FirstOpenActivity.class));
                                        finish();
                                    }
                                }
                            });
                }
            }
        });

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
