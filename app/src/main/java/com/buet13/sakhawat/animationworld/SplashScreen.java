package com.buet13.sakhawat.animationworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    //private static int SPLASH_TIME_OUT = 4000;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        pbar = findViewById(R.id.progress_bar);

        //new Handler().postDelayed(new Runnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                showProgressbar();
                startNextActivity();
            }
        });
        thread.start();
        //}, SPLASH_TIME_OUT);
    }

    private void showProgressbar(){
        for(int i=1;i<100;i++){
            try{
                pbar.setProgress(i);
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void startNextActivity(){
        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}

