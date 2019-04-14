package com.Pruff.pruff;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.pruff.R;

public class WaitPage extends AppCompatActivity {

    Button exit,verify;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_page);

        auth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        exit = findViewById(R.id.exit);


        verify = findViewById(R.id.verifyEmail);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.sendEmailVerification().addOnCompleteListener(WaitPage.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(WaitPage.this, "Verification email sent to " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            auth.signOut();
                        } else {
                            Toast.makeText(WaitPage.this, "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                finish();
                System.exit(0);
            }
        });
    }
}
