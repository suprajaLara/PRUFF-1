package com.google.pruffap;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rel2,rel3;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            rel2.setVisibility(View.VISIBLE);
            rel3.setVisibility(View.VISIBLE);

        }
    };

    private FirebaseAuth auth;
    private EditText email,password;
    private Button login,signup,forgot_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rel2 = findViewById(R.id.rel_lay_2);
        rel3 = findViewById(R.id.rel_lay_3);

        FirebaseApp.initializeApp(getApplicationContext());
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null)
        {

            startActivity(new Intent(MainActivity.this,FirstOpenActivity.class));
            finish();

        }

        handler.postDelayed(runnable,2000);



        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signUP);
        forgot_pass = findViewById(R.id.forgotPassword);
        login = findViewById(R.id.login);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,About.class));

            }
        });

        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ForgotReset.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Eid = email.getText().toString();
                final String pass = password.getText().toString();

                if(TextUtils.isEmpty(Eid))
                {
                    Toast.makeText(getApplicationContext(),"Enter email address!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(getApplicationContext(),"Enter password!!",Toast.LENGTH_LONG).show();
                    return;
                }

                auth.signInWithEmailAndPassword(Eid,pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.

                        if (!task.isSuccessful())
                        {

                            if(pass.length()<6)
                            {
                                password.setError(getString(R.string.minimum_password));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),getString(R.string.auth_failed),Toast.LENGTH_LONG).show();
                            }

                        }
                        else
                        {
                            startActivity(new Intent(MainActivity.this,FirstOpenActivity.class));
                            finish();
                        }

                    }
                });
            }
        });

    }
}
//References : https://www.youtube.com/watch?v=-7xLyPLJ_NI