package com.ardityoc.scribdviewer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ardityoc.scribdviewer.R;
import com.ardityoc.scribdviewer.databinding.ActivityMainBinding;
import com.ardityoc.scribdviewer.databinding.FragmentFirstBinding;
import com.ardityoc.scribdviewer.utils.Directs;
import com.ardityoc.scribdviewer.utils.SharedPreferences;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (SharedPreferences.loadName(getContext()).isEmpty()){
            binding.nama.setText("Guest");
        }else{
            binding.nama.setText(SharedPreferences.loadName(getContext()));
        }

        if (SharedPreferences.loadID(getContext()).isEmpty()){
            binding.temp.setText("Tidak ada");
        }else{
            binding.temp.setText(SharedPreferences.loadID(getContext()));
        }

        binding.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Directs.AboutDirect(getContext(),false);
            }
        });

        binding.temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.scribdID.setText(SharedPreferences.loadID(getContext()));
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Banh lw anime yh?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                if (TextUtils.isEmpty(binding.scribdID.getText().toString())){
                    binding.scribdID.setError("Harap mengisi scribdID");
                }else{
                    SharedPreferences.saveID(binding.scribdID.getText().toString(),getContext());

                    Intent intent = new Intent(getContext(), WebViewActivity.class);

                    intent.putExtra("ID",binding.scribdID.getText().toString());

                    getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}