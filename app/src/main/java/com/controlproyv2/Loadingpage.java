package com.controlproyv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loadingpage extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Loadingpage.this, MainActivity.class);
                startActivity(intent);
                Loadingpage.this.finish();
            }
        }, 8000);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progess_bar);
        textView = findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(4f);
        progressBar.setScaleX(14);
        progressAnimation();
    }

    public void progressAnimation() {

        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);

        anim.setDuration(8000);

        progressBar.setAnimation(anim);


    }


}
