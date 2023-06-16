package com.suhun.threadmessagehandler;

import android.util.Log;

public class MyThread extends Thread{
    private String tag = MyThread.class.getSimpleName();
    private String name;
    private String op;

    public MyThread(String name, String op){
        this.name = name;
        this.op = op;
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
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                Log.d(tag, "+++++MyThread runMethod2 Exception++++" + e.getMessage());
            }
        }
    }
}
