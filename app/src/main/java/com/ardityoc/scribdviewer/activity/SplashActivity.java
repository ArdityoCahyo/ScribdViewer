package com.ardityoc.scribdviewer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.ardityoc.scribdviewer.R;
import com.ardityoc.scribdviewer.data.CheckNetwork;
import com.ardityoc.scribdviewer.utils.Directs;
import com.ardityoc.scribdviewer.utils.SharedPreferences;

public class SplashActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(CheckNetwork.isInternetAvailable(SplashActivity.this))
                {

                    if (!SharedPreferences.loadName(context).isEmpty()){
                        Log.i("DEBUG", "onSharedPreference: Name not null");
                        Directs.MainDirect(context, true);
                    }else{
                        Log.i("DEBUG", "onSharedPreference: Name null");
                        Directs.OnBoardDirect(context, true);
                    }
                }
                else
                {
                    Directs.NoInternetDirect(context, true);
                    Toast.makeText(context,"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000L);
    }
}