package com.suhun.threadmessagehandler;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

public class MyThread extends Thread{
    private String tag = MyThread.class.getSimpleName();
    private MainActivity activity;
    private String name;
    private String op;
    private MyUIHandler myUIHandler;

    public MyThread(Context context, String name, String op){
        this.activity = (MainActivity)context;
        this.name = name;
        this.op = op;
        myUIHandler = new MyUIHandler(this.activity);
    }

    @Override
    public void run() {
        super.run();
        if(op.equals("")){
            Log.d(tag, "+++++MyThread Not yet+++++");
        }else if(op.equals("method1")){
            Log.d(tag, "+++++MyThread run method1+++++");
            this.runMethod1();
        }else if(op.equals("method2")){
            Log.d(tag, "+++++MyThread run method2+++++");
            this.runMethod2();
        }
    }

    private void runMethod1(){
        for(int i=1;i<=20;i++){
            Log.d(tag, "+++++MyThread runMethod1++++" +":"+this.name+i);
            Message msg = new Message();
            Bundle bundle = new Bundle();
            msg.what=1;
            String result = this.name + i;
            bundle.putString("counterResult1", result);
            msg.setData(bundle);
            myUIHandler.sendMessage(msg);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                Log.d(tag, "+++++MyThread runMethod1 Exception++++"+e.getMessage());
            }
        }
    }

    private void runMethod2(){
        for(int i=1;i<=20;i++) {
            Log.d(tag, "+++++MyThread runMethod1++++" + i);
            Message msg = new Message();
            Bundle bundle = new Bundle();
            msg.what=2;
            String result = ""+i;
            bundle.putString("counterResult2", result);
            msg.setData(bundle);
            myUIHandler.sendMessage(msg);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                Log.d(tag, "+++++MyThread runMethod2 Exception++++" + e.getMessage());
            }
        }
    }
}
