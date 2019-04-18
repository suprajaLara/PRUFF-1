package com.google.pruffap;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    FirebaseAuth mAuth;
    RelativeLayout rel_splash;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            //rel_splash.setVisibility(View.VISIBLE);
            startActivity(new Intent(SplashScreen.this,FirstOpenActivity.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null) {

            setContentView(R.layout.activity_splash_screen);
            rel_splash = findViewById(R.id.rel_lay_splash);
            //rel_splash.setVisibility(View.VISIBLE);

            handler.postDelayed(r, 2000);
            return;
        }
        startActivity(new Intent(SplashScreen.this,MainActivity.class));
        finish();
    }

}
