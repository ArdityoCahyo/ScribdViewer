package com.ardityoc.scribdviewer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ardityoc.scribdviewer.R;
import com.ardityoc.scribdviewer.databinding.ActivityMainBinding;
import com.ardityoc.scribdviewer.databinding.ActivityOnBoardBinding;
import com.ardityoc.scribdviewer.utils.Directs;
import com.ardityoc.scribdviewer.utils.SharedPreferences;
import com.google.android.material.snackbar.Snackbar;

public class OnBoardActivity extends AppCompatActivity {

    private ActivityOnBoardBinding binding;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = this;

        initComponents();
    }

    private void initComponents(){
        binding.iyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.saveName(binding.nama.getText().toString(),context);
                Directs.MainDirect(context,true);
            }
        });
    }
}