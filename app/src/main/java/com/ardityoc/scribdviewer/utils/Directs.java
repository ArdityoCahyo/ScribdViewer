package com.ardityoc.scribdviewer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.ardityoc.scribdviewer.activity.AboutActivity;
import com.ardityoc.scribdviewer.activity.MainActivity;
import com.ardityoc.scribdviewer.activity.NoInternetActivity;
import com.ardityoc.scribdviewer.activity.OnBoardActivity;

public class Directs {

    public static void OnBoardDirect(Context context, Boolean finish){
        context.startActivity(new Intent(context, OnBoardActivity.class));
        if (finish){
            ((Activity)(context)).finish();
        }
    }

    public static void MainDirect(Context context, Boolean finish){
        context.startActivity(new Intent(context, MainActivity.class));
        if (finish){
            ((Activity)(context)).finish();
        }
    }

    public static void AboutDirect(Context context, Boolean finish){
        context.startActivity(new Intent(context, AboutActivity.class));
        if (finish){
            ((Activity)(context)).finish();
        }
    }

    public static void NoInternetDirect(Context context, Boolean finish){
        context.startActivity(new Intent(context, NoInternetActivity.class));
        if (finish == true){
            ((Activity)(context)).finish();
        }
    }

}
