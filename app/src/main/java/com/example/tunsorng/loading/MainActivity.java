package com.example.tunsorng.loading;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnShowProgressbar=findViewById(R.id.btnShowProgress);
        btnShowProgressbar.setOnClickListener(v->{
        new LoadingDialogAsyncTask(MainActivity.this).execute();
    });

    }
}
