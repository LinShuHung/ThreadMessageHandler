package com.suhun.threadmessagehandler;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyUIHandler extends Handler {
    private String tag = MyUIHandler.class.getSimpleName();
    private MainActivity activity;
    public MyUIHandler(Context context){
        this.activity = (MainActivity) context;
    }
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        String result="";
        if(msg.what==1){
            result = msg.getData().getString("counterResult1");
            activity.showResult1.setText(result);
        }else if(msg.what==2){
            Bundle bundle = msg.getData();
            result = msg.getData().getString("counterResult2");
            activity.showResult2.setText(result);
        }
    }
}
