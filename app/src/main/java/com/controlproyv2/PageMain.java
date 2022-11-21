package com.controlproyv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PageMain extends AppCompatActivity implements View.OnClickListener {
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
    }

    @Override
    public void onClick(View v) {
        button2 = (Button) findViewById(R.id.button3);
        Intent intent = new Intent(PageMain.this, PageMain.class);
        startActivity(intent);
    }

}

