package com.ardityoc.scribdviewer.activity;

import android.os.Bundle;

import com.ardityoc.scribdviewer.databinding.ActivityAboutBinding;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}