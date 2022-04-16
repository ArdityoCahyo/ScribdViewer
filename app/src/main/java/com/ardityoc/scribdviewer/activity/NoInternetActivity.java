package com.ardityoc.scribdviewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ardityoc.scribdviewer.R;


public class NoInternetActivity extends AppCompatActivity {

    private Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        retryButton = findViewById(R.id.nointernet_button);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reload();
            }
        });
    }

    public void reload(){
        startActivity(new Intent(getApplicationContext(), SplashActivity.class));
        finish();
    }
}